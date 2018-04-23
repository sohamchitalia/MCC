set val(x) 1000;
set val(y) 1000; 
set val(rlen) 5;
set val(nn) [expr $val(rlen) * $val(rlen)];
set val(stop) 200.0;
set val(routing) AODV;
set ns [new Simulator];
set topo [new Topography];
$topo load_flatgrid $val(x) $val(y)
set tracefd [open wireless.tr w]
$ns trace-all $tracefd
$ns use_newtrace
set namtrace [open wireless.nam w]
$ns namtrace-all-wireless $namtrace $val(x) $val(y)
set god_ [create-god $val(nn)]

$ns node-config -adhocRouting $val(rp) \
-llType $val(ll) 
-macType Mac/802_11 \
-ifqType Queue/DropTail/PriQueue \
-ifqLen 50 \
-antType Antenna/OmniAntenna \
-propType Propagation/TwoRayGround \
-phyType Phy/WirelessPhy \
-channelType Channel/WirelessChannel \
-topoInstance $topo \
-agentTrace ON \
-routerTrace ON \
-macTrace OFF \

for { set i 0} {$i<$val(nn)} {incr i} {
	set n($i) [$ns node]
}

set gridspace [expr $val(x)/$val(rlen)]

for { set i 0} {$i<$val(nn)} {incr i} {
	for { set j 0} {$j<$val(nn)} {incr j} {
		set a [expr $j + [expr $i.$val(rlen)]]
		$n($i) set X_ [expr 0.0+[expr $i + $gridspace]] 
		$n($i) set Y_ [expr 0.0+[expr $i + $gridspace]] 
		$n($i) set Z_ 0.0
	}
}

for { set i 0} {$i<$val(nn)} {incr i} {
	$ns initial_node_pos $n($i) $val(nn)
}

for { set i 0} {$i<$val(nn)} {incr i} {
	$ns at $val(stop).0 " $n($i) reset";
}

$ns at $val(stop).002 "puts \" Ns existing .\"; $ns halt"

puts " Starting Simulation"
set udp0 [new Agent/UDP]
$ns attach-agent $n(0) $udp0
set nullw0 [new Agent/Null]
$ns attach-agent %n(15) $nullw0
set cbrw0 [new Application/Traffic/CBR]
$cbrw0 attach-agent $udpw0
$ns connect $udpw0 $nullw0
$ns at 1.0 "$cbrw start"
%ns at 6.0 "cbrw0 stop"

$ns run 
							
