package frc.paths;

import com.team319.trajectory.Path;

public class SearchAB extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,1.2540,7.5000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0000},
				{0.0200,1.2620,7.5000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0000},
				{0.0200,1.2740,7.5000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,0.0000,0.0000},
				{0.0200,1.2900,7.5000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,0.0000,0.0000},
				{0.0200,1.3100,7.5000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,0.0000,0.0000},
				{0.0200,1.3340,7.5000,0.0840,1.2000,10.0000,-0.0000,0.0840,1.2000,10.0000,0.0000,0.0840,1.2000,10.0000,-0.0000,0.0000},
				{0.0200,1.3620,7.5000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,0.0000,0.0000},
				{0.0200,1.3940,7.5000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,0.0000,0.0000},
				{0.0200,1.4300,7.5000,0.1800,1.8000,10.0000,-0.0000,0.1800,1.8000,10.0000,0.0000,0.1800,1.8000,10.0000,-0.0000,0.0000},
				{0.0200,1.4700,7.5000,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,0.0000,0.0000},
				{0.0200,1.5140,7.5000,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,0.0000,0.0000},
				{0.0200,1.5620,7.5000,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,0.0000,0.0000},
				{0.0200,1.6140,7.5000,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,0.0000,0.0000},
				{0.0200,1.6700,7.5000,0.4200,2.8000,10.0000,-0.0000,0.4200,2.8000,10.0000,0.0000,0.4200,2.8000,10.0000,-0.0000,0.0000},
				{0.0200,1.7300,7.5000,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,0.0000,0.0000},
				{0.0200,1.7940,7.5000,0.5440,3.2000,10.0000,-0.0000,0.5440,3.2000,10.0000,0.0000,0.5440,3.2000,10.0000,-0.0000,0.0000},
				{0.0200,1.8620,7.5000,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,10.0000,0.0000,0.0000},
				{0.0200,1.9340,7.5000,0.6840,3.6000,10.0000,-0.0000,0.6840,3.6000,10.0000,0.0000,0.6840,3.6000,10.0000,-0.0000,0.0000},
				{0.0200,2.0100,7.5000,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,10.0000,0.0000,0.0000},
				{0.0200,2.0900,7.5000,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,10.0000,0.0000,0.0000},
				{0.0200,2.1740,7.5000,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,10.0000,0.0000,0.0000},
				{0.0200,2.2620,7.5000,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,10.0000,0.0000,0.0000},
				{0.0200,2.3540,7.5000,1.1040,4.6000,10.0000,-0.0000,1.1040,4.6000,10.0000,0.0000,1.1040,4.6000,10.0000,-0.0000,0.0000},
				{0.0200,2.4500,7.5000,1.2000,4.8000,10.0000,0.0000,1.2000,4.8000,10.0000,0.0000,1.2000,4.8000,10.0000,0.0000,0.0000},
				{0.0200,2.5500,7.5000,1.3000,5.0000,10.0000,-0.0000,1.3000,5.0000,10.0000,0.0000,1.3000,5.0000,10.0000,-0.0000,0.0000},
				{0.0200,2.6540,7.5000,1.4040,5.2000,10.0000,-0.0000,1.4040,5.2000,10.0000,0.0000,1.4040,5.2000,10.0000,-0.0000,0.0000},
				{0.0200,2.7620,7.5000,1.5120,5.4000,10.0000,0.0000,1.5120,5.4000,10.0000,0.0000,1.5120,5.4000,10.0000,0.0000,0.0000},
				{0.0200,2.8740,7.5000,1.6240,5.6000,10.0000,-0.0000,1.6240,5.6000,10.0000,0.0000,1.6240,5.6000,10.0000,-0.0000,0.0000},
				{0.0200,2.9900,7.5000,1.7400,5.8000,10.0000,0.0000,1.7400,5.8000,10.0000,0.0000,1.7400,5.8000,10.0000,0.0000,0.0000},
				{0.0200,3.1100,7.5000,1.8600,6.0000,10.0000,0.0000,1.8600,6.0000,10.0000,0.0000,1.8600,6.0000,10.0000,0.0000,0.0000},
				{0.0200,3.2340,7.5000,1.9840,6.2000,10.0000,-0.0000,1.9840,6.2000,10.0000,0.0000,1.9840,6.2000,10.0000,-0.0000,0.0000},
				{0.0200,3.3620,7.5000,2.1120,6.4000,10.0000,0.0000,2.1120,6.4000,10.0000,0.0000,2.1120,6.4000,10.0000,0.0000,0.0000},
				{0.0200,3.4940,7.5000,2.2440,6.6000,10.0000,-0.0000,2.2440,6.6000,10.0000,0.0000,2.2440,6.6000,10.0000,-0.0000,0.0000},
				{0.0200,3.6300,7.5000,2.3800,6.8000,10.0000,0.0000,2.3800,6.8000,10.0000,0.0000,2.3800,6.8000,10.0000,0.0000,0.0000},
				{0.0200,3.7700,7.5000,2.5200,7.0000,10.0000,0.0000,2.5200,7.0000,10.0000,0.0000,2.5200,7.0000,10.0000,0.0000,0.0000},
				{0.0200,3.9140,7.5000,2.6640,7.2000,10.0000,0.0000,2.6640,7.2000,10.0000,0.0000,2.6640,7.2000,10.0000,0.0000,0.0000},
				{0.0200,4.0620,7.5000,2.8120,7.4000,10.0000,-0.0000,2.8120,7.4000,10.0000,0.0000,2.8120,7.4000,10.0000,-0.0000,0.0000},
				{0.0200,4.2140,7.5000,2.9640,7.6000,10.0000,-0.0000,2.9640,7.6000,10.0000,0.0000,2.9640,7.6000,10.0000,-0.0000,0.0000},
				{0.0200,4.3700,7.5000,3.1200,7.8000,10.0000,0.0000,3.1200,7.8000,10.0000,0.0000,3.1200,7.8000,10.0000,0.0000,0.0000},
				{0.0200,4.5300,7.5000,3.2800,8.0000,10.0000,-0.0000,3.2800,8.0000,10.0000,0.0000,3.2800,8.0000,10.0000,-0.0000,0.0000},
				{0.0200,4.6940,7.5000,3.4440,8.2000,10.0000,0.0000,3.4440,8.2000,10.0000,0.0000,3.4440,8.2000,10.0000,0.0000,0.0000},
				{0.0200,4.8620,7.5000,3.6120,8.4000,10.0000,0.0000,3.6120,8.4000,10.0000,0.0000,3.6120,8.4000,10.0000,0.0000,0.0000},
				{0.0200,5.0340,7.5000,3.7840,8.6000,10.0000,0.0000,3.7840,8.6000,10.0000,0.0000,3.7840,8.6000,10.0000,0.0000,0.0000},
				{0.0200,5.2100,7.5000,3.9600,8.8000,10.0000,-0.0000,3.9600,8.8000,10.0000,0.0000,3.9600,8.8000,10.0000,-0.0000,0.0000},
				{0.0200,5.3900,7.5000,4.1400,9.0000,10.0000,0.0000,4.1400,9.0000,10.0000,0.0000,4.1400,9.0000,10.0000,0.0000,0.0000},
				{0.0200,5.5740,7.5000,4.3240,9.2000,10.0000,-0.0000,4.3240,9.2000,10.0000,0.0000,4.3240,9.2000,10.0000,-0.0000,0.0000},
				{0.0200,5.7540,7.5000,4.5040,9.0000,-10.0000,-1000.0000,4.5040,9.0000,-10.0000,0.0000,4.5040,9.0000,-10.0000,-1000.0000,0.0000},
				{0.0200,5.9300,7.5000,4.6800,8.8000,-10.0000,-0.0000,4.6800,8.8000,-10.0000,0.0000,4.6800,8.8000,-10.0000,-0.0000,0.0000},
				{0.0200,6.1020,7.5000,4.8520,8.6000,-10.0000,0.0000,4.8520,8.6000,-10.0000,0.0000,4.8520,8.6000,-10.0000,0.0000,0.0000},
				{0.0200,6.2500,7.5000,5.0000,7.4000,-60.0000,-2500.0000,5.0000,8.4000,-10.0000,0.0000,5.0000,7.4000,-60.0000,-2500.0000,0.0000},
				{0.0200,6.2500,7.5000,5.0000,0.0000,-370.0000,-15500.0000,5.0000,8.2000,-10.0000,0.0000,5.0000,0.0000,-370.0000,-15500.0000,0.0000},
				{0.0200,6.2500,7.5000,5.0000,0.0000,0.0000,18500.0000,5.0000,8.0000,-10.0000,0.0000,5.0000,0.0000,0.0000,18500.0000,0.0000},
				{0.0200,6.2500,7.5000,5.0000,0.0000,0.0000,0.0000,5.0000,7.8000,-10.0000,0.0000,5.0000,0.0000,0.0000,0.0000,0.0000},
				{0.0200,6.4100,7.4996,5.1600,8.0000,399.9990,19999.9496,5.1600,8.0000,10.0000,0.0000,5.1600,8.0000,399.9990,19999.9496,-0.0075},
				{0.0200,6.5700,7.4969,5.3200,7.9998,-0.0067,-20000.2864,5.3200,8.0000,10.0000,0.0000,5.3200,7.9998,-0.0067,-20000.2864,-0.0290},
				{0.0200,6.7298,7.4896,5.4800,7.9996,-0.0120,-0.2625,5.4800,8.0000,10.0000,0.0000,5.4800,7.9996,-0.0120,-0.2625,-0.0633},
				{0.0200,6.8892,7.4760,5.6400,7.9993,-0.0164,-0.2209,5.6400,8.0000,10.0000,0.0000,5.6400,7.9993,-0.0164,-0.2209,-0.1099},
				{0.0200,7.0477,7.4540,5.8000,7.9989,-0.0198,-0.1698,5.8000,8.0000,10.0000,0.0000,5.8000,7.9989,-0.0198,-0.1698,-0.1678},
				{0.0200,7.2044,7.4220,5.9599,7.9985,-0.0212,-0.0681,5.9600,8.0000,10.0000,0.0000,5.9599,7.9985,-0.0212,-0.0681,-0.2357},
				{0.0200,7.3584,7.3789,6.1199,7.9981,-0.0191,0.1041,6.1200,8.0000,10.0000,0.0000,6.1199,7.9981,-0.0191,0.1041,-0.3116},
				{0.0200,7.5086,7.3238,6.2798,7.9978,-0.0127,0.3183,6.2800,8.0000,10.0000,0.0000,6.2798,7.9978,-0.0127,0.3183,-0.3924},
				{0.0200,7.6538,7.2566,6.4398,7.9978,-0.0029,0.4889,6.4400,8.0000,10.0000,0.0000,6.4398,7.9978,-0.0029,0.4889,-0.4743},
				{0.0200,7.7930,7.1779,6.5998,7.9979,0.0075,0.5220,6.6000,8.0000,10.0000,0.0000,6.5998,7.9979,0.0075,0.5220,-0.5533},
				{0.0200,7.9259,7.0889,6.7597,7.9982,0.0155,0.3977,6.7600,8.0000,10.0000,0.0000,6.7597,7.9982,0.0155,0.3977,-0.6263},
				{0.0200,8.0524,6.9909,6.9197,7.9986,0.0192,0.1895,6.9200,8.0000,10.0000,0.0000,6.9197,7.9986,0.0192,0.1895,-0.6909},
				{0.0200,8.1727,6.8855,7.0797,7.9990,0.0192,-0.0029,7.0800,8.0000,10.0000,0.0000,7.0797,7.9990,0.0192,-0.0029,-0.7459},
				{0.0200,8.2877,6.7742,7.2397,7.9993,0.0167,-0.1244,7.2400,8.0000,10.0000,0.0000,7.2397,7.9993,0.0167,-0.1244,-0.7909},
				{0.0200,8.3981,6.6584,7.3996,7.9996,0.0132,-0.1745,7.4000,8.0000,10.0000,0.0000,7.3996,7.9996,0.0132,-0.1745,-0.8260},
				{0.0200,8.5049,6.5393,7.5596,7.9998,0.0096,-0.1785,7.5600,8.0000,10.0000,0.0000,7.5596,7.9998,0.0096,-0.1785,-0.8515},
				{0.0200,8.6092,6.4180,7.7196,7.9999,0.0064,-0.1624,7.7200,8.0000,10.0000,0.0000,7.7196,7.9999,0.0064,-0.1624,-0.8679},
				{0.0200,8.7121,6.2954,7.8796,8.0000,0.0035,-0.1432,7.8800,8.0000,10.0000,0.0000,7.8796,8.0000,0.0035,-0.1432,-0.8755},
				{0.0200,8.8146,6.1726,8.0396,8.0000,0.0009,-0.1299,8.0400,8.0000,10.0000,0.0000,8.0396,8.0000,0.0009,-0.1299,-0.8743},
				{0.0200,8.9178,6.0503,8.1996,8.0000,-0.0016,-0.1261,8.2000,8.0000,10.0000,0.0000,8.1996,8.0000,-0.0016,-0.1261,-0.8645},
				{0.0200,9.0226,5.9294,8.3596,7.9999,-0.0042,-0.1325,8.3600,8.0000,10.0000,0.0000,8.3596,7.9999,-0.0042,-0.1325,-0.8458},
				{0.0200,9.1303,5.8111,8.5196,7.9997,-0.0072,-0.1479,8.5200,8.0000,10.0000,0.0000,8.5196,7.9997,-0.0072,-0.1479,-0.8178},
				{0.0200,9.2418,5.6964,8.6796,7.9995,-0.0105,-0.1674,8.6800,8.0000,10.0000,0.0000,8.6796,7.9995,-0.0105,-0.1674,-0.7801},
				{0.0200,9.3581,5.5865,8.8396,7.9992,-0.0142,-0.1803,8.8400,8.0000,10.0000,0.0000,8.8396,7.9992,-0.0142,-0.1803,-0.7325},
				{0.0200,9.4800,5.4828,8.9996,7.9989,-0.0175,-0.1671,9.0000,8.0000,10.0000,0.0000,8.9996,7.9989,-0.0175,-0.1671,-0.6750},
				{0.0200,9.6081,5.3870,9.1596,7.9985,-0.0195,-0.1003,9.1600,8.0000,10.0000,0.0000,9.1596,7.9985,-0.0195,-0.1003,-0.6080},
				{0.0200,9.7426,5.3005,9.3195,7.9981,-0.0187,0.0415,9.3200,8.0000,10.0000,0.0000,9.3195,7.9981,-0.0187,0.0415,-0.5332},
				{0.0200,9.8835,5.2248,9.4795,7.9979,-0.0138,0.2458,9.4800,8.0000,10.0000,0.0000,9.4795,7.9979,-0.0138,0.2458,-0.4531},
				{0.0200,10.0263,5.1622,9.6354,7.7979,-9.9967,-499.1486,9.6360,7.8000,-10.0000,0.0000,9.6354,7.7979,-9.9967,-499.1486,-0.3732},
				{0.0200,10.1699,5.1122,9.7874,7.5982,-9.9878,0.4467,9.7880,7.6000,-10.0000,0.0000,9.7874,7.5982,-9.9878,0.4467,-0.2971},
				{0.0200,10.3128,5.0739,9.9354,7.3985,-9.9824,0.2683,9.9360,7.4000,-10.0000,0.0000,9.9354,7.3985,-9.9824,0.2683,-0.2278},
				{0.0200,10.4540,5.0458,10.0793,7.1989,-9.9812,0.0636,10.0800,7.2000,-10.0000,0.0000,10.0793,7.1989,-9.9812,0.0636,-0.1671},
				{0.0200,10.5926,5.0261,10.2193,6.9992,-9.9829,-0.0878,10.2200,7.0000,-10.0000,0.0000,10.2193,6.9992,-9.9829,-0.0878,-0.1159},
				{0.0200,10.7280,5.0133,10.3553,6.7995,-9.9862,-0.1621,10.3560,6.8000,-10.0000,0.0000,10.3553,6.7995,-9.9862,-0.1621,-0.0745},
				{0.0200,10.8597,5.0056,10.4873,6.5997,-9.9897,-0.1771,10.4880,6.6000,-10.0000,0.0000,10.4873,6.5997,-9.9897,-0.1771,-0.0425},
				{0.0200,10.9877,5.0018,10.6153,6.3999,-9.9929,-0.1608,10.6160,6.4000,-10.0000,0.0000,10.6153,6.3999,-9.9929,-0.1608,-0.0197},
				{0.0200,11.1117,5.0003,10.7393,6.1999,-9.9956,-0.1348,10.7400,6.2000,-10.0000,0.0000,10.7393,6.1999,-9.9956,-0.1348,-0.0056},
				{0.0200,11.2317,5.0000,10.8593,6.0000,-9.9978,-0.1110,10.8600,6.0000,-10.0000,0.0000,10.8593,6.0000,-9.9978,-0.1110,-0.0001},
				{0.0200,11.3517,5.0000,10.9793,6.0000,0.0004,499.9112,10.9800,6.0000,10.0000,0.0000,10.9793,6.0000,0.0004,499.9112,0.0005},
				{0.0200,11.4717,5.0002,11.0993,6.0000,-0.0001,-0.0227,11.1000,6.0000,10.0000,0.0000,11.0993,6.0000,-0.0001,-0.0227,0.0027},
				{0.0200,11.5917,5.0007,11.2193,6.0000,-0.0002,-0.0070,11.2200,6.0000,10.0000,0.0000,11.2193,6.0000,-0.0002,-0.0070,0.0072},
				{0.0200,11.7117,5.0020,11.3393,6.0000,-0.0004,-0.0125,11.3400,6.0000,10.0000,0.0000,11.3393,6.0000,-0.0004,-0.0125,0.0147},
				{0.0200,11.8316,5.0044,11.4593,6.0000,-0.0008,-0.0199,11.4600,6.0000,10.0000,0.0000,11.4593,6.0000,-0.0008,-0.0199,0.0258},
				{0.0200,11.9516,5.0084,11.5793,5.9999,-0.0014,-0.0303,11.5800,6.0000,10.0000,0.0000,11.5793,5.9999,-0.0014,-0.0303,0.0413},
				{0.0200,12.0714,5.0145,11.6993,5.9999,-0.0024,-0.0455,11.7000,6.0000,10.0000,0.0000,11.6993,5.9999,-0.0024,-0.0455,0.0620},
				{0.0200,12.1911,5.0235,11.8193,5.9998,-0.0037,-0.0684,11.8200,6.0000,10.0000,0.0000,11.8193,5.9998,-0.0037,-0.0684,0.0889},
				{0.0200,12.3104,5.0361,11.9393,5.9997,-0.0058,-0.1033,11.9400,6.0000,10.0000,0.0000,11.9393,5.9997,-0.0058,-0.1033,0.1234},
				{0.0200,12.4291,5.0534,12.0593,5.9995,-0.0089,-0.1556,12.0600,6.0000,10.0000,0.0000,12.0593,5.9995,-0.0089,-0.1556,0.1670},
				{0.0200,12.5469,5.0765,12.1793,5.9993,-0.0135,-0.2310,12.1800,6.0000,10.0000,0.0000,12.1793,5.9993,-0.0135,-0.2310,0.2217},
				{0.0200,12.6630,5.1067,12.2992,5.9989,-0.0201,-0.3287,12.3000,6.0000,10.0000,0.0000,12.2992,5.9989,-0.0201,-0.3287,0.2895},
				{0.0200,12.7765,5.1455,12.4192,5.9983,-0.0286,-0.4244,12.4200,6.0000,10.0000,0.0000,12.4192,5.9983,-0.0286,-0.4244,0.3724},
				{0.0200,12.8860,5.1945,12.5392,5.9975,-0.0374,-0.4395,12.5400,6.0000,10.0000,0.0000,12.5392,5.9975,-0.0374,-0.4395,0.4717},
				{0.0200,12.9896,5.2549,12.6591,5.9967,-0.0418,-0.2226,12.6600,6.0000,10.0000,0.0000,12.6591,5.9967,-0.0418,-0.2226,0.5866},
				{0.0200,13.0851,5.3274,12.7790,5.9960,-0.0349,0.3474,12.7800,6.0000,10.0000,0.0000,12.7790,5.9960,-0.0349,0.3474,0.7130},
				{0.0200,13.1705,5.4116,12.8989,5.9957,-0.0133,1.0805,12.9000,6.0000,10.0000,0.0000,12.8989,5.9957,-0.0133,1.0805,0.8435},
				{0.0200,13.2444,5.5060,13.0189,5.9960,0.0150,1.4114,13.0200,6.0000,10.0000,0.0000,13.0189,5.9960,0.0150,1.4114,0.9694},
				{0.0200,13.3064,5.6087,13.1388,5.9967,0.0354,1.0199,13.1400,6.0000,10.0000,0.0000,13.1388,5.9967,0.0354,1.0199,1.0835},
				{0.0200,13.3571,5.7174,13.2587,5.9976,0.0411,0.2897,13.2600,6.0000,10.0000,0.0000,13.2587,5.9976,0.0411,0.2897,1.1822},
				{0.0200,13.3978,5.8303,13.3787,5.9983,0.0363,-0.2401,13.3800,6.0000,10.0000,0.0000,13.3787,5.9983,0.0363,-0.2401,1.2649},
				{0.0200,13.4299,5.9459,13.4987,5.9988,0.0278,-0.4270,13.5000,6.0000,10.0000,0.0000,13.4987,5.9988,0.0278,-0.4270,1.3329},
				{0.0200,13.4548,6.0632,13.6187,5.9992,0.0197,-0.4033,13.6200,6.0000,10.0000,0.0000,13.6187,5.9992,0.0197,-0.4033,1.3881},
				{0.0200,13.4739,6.1817,13.7387,5.9995,0.0135,-0.3104,13.7400,6.0000,10.0000,0.0000,13.7387,5.9995,0.0135,-0.3104,1.4323},
				{0.0200,13.4883,6.3008,13.8587,5.9997,0.0092,-0.2188,13.8600,6.0000,10.0000,0.0000,13.8587,5.9997,0.0092,-0.2188,1.4673},
				{0.0200,13.4990,6.4203,13.9786,5.9998,0.0062,-0.1490,13.9800,6.0000,10.0000,0.0000,13.9786,5.9998,0.0062,-0.1490,1.4943},
				{0.0200,13.5069,6.5401,14.0986,5.9999,0.0041,-0.1015,14.1000,6.0000,10.0000,0.0000,14.0986,5.9999,0.0041,-0.1015,1.5142},
				{0.0200,13.5128,6.6599,14.2186,6.0000,0.0027,-0.0714,14.2200,6.0000,10.0000,0.0000,14.2186,6.0000,0.0027,-0.0714,1.5277},
				{0.0200,13.5175,6.7798,14.3386,6.0000,0.0016,-0.0549,14.3400,6.0000,10.0000,0.0000,14.3386,6.0000,0.0016,-0.0549,1.5347},
				{0.0200,13.5217,6.8998,14.4586,6.0000,0.0006,-0.0521,14.4600,6.0000,10.0000,0.0000,14.4586,6.0000,0.0006,-0.0521,1.5375},
				{0.0200,13.5249,7.0197,14.5786,5.9999,-0.0034,-0.2013,14.5800,6.0000,10.0000,0.0000,14.5786,5.9999,-0.0034,-0.2013,1.5541},
				{0.0200,13.5250,7.1397,14.6986,5.9997,-0.0108,-0.3652,14.7000,6.0000,10.0000,0.0000,14.6986,5.9997,-0.0108,-0.3652,1.5878},
				{0.0200,13.5201,7.2596,14.8186,5.9994,-0.0181,-0.3697,14.8200,6.0000,10.0000,0.0000,14.8186,5.9994,-0.0181,-0.3697,1.6387},
				{0.0200,13.5081,7.3790,14.9386,5.9988,-0.0265,-0.4176,14.9400,6.0000,10.0000,0.0000,14.9386,5.9988,-0.0265,-0.4176,1.7073},
				{0.0200,13.4868,7.4970,15.0586,5.9981,-0.0347,-0.4121,15.0600,6.0000,10.0000,0.0000,15.0586,5.9981,-0.0347,-0.4121,1.7938},
				{0.0200,13.4544,7.6125,15.1785,5.9973,-0.0389,-0.2074,15.1800,6.0000,10.0000,0.0000,15.1785,5.9973,-0.0389,-0.2074,1.8966},
				{0.0200,13.4097,7.7238,15.2984,5.9967,-0.0327,0.3074,15.3000,6.0000,10.0000,0.0000,15.2984,5.9967,-0.0327,0.3074,2.0115},
				{0.0200,13.3521,7.8290,15.4184,5.9964,-0.0134,0.9693,15.4200,6.0000,10.0000,0.0000,15.4184,5.9964,-0.0134,0.9693,2.1309},
				{0.0200,13.2826,7.9267,15.5383,5.9967,0.0123,1.2830,15.5400,6.0000,10.0000,0.0000,15.5383,5.9967,0.0123,1.2830,2.2461},
				{0.0200,13.2028,8.0163,15.6583,5.9973,0.0313,0.9499,15.6600,6.0000,10.0000,0.0000,15.6583,5.9973,0.0313,0.9499,2.3500},
				{0.0200,13.1147,8.0977,15.7782,5.9980,0.0371,0.2903,15.7800,6.0000,10.0000,0.0000,15.7782,5.9980,0.0371,0.2903,2.4384},
				{0.0200,13.0203,8.1718,15.8982,5.9987,0.0330,-0.2080,15.9000,6.0000,10.0000,0.0000,15.8982,5.9987,0.0330,-0.2080,2.5105},
				{0.0200,12.9214,8.2397,16.0182,5.9992,0.0250,-0.3958,16.0200,6.0000,10.0000,0.0000,16.0182,5.9992,0.0250,-0.3958,2.5669},
				{0.0200,12.8192,8.3027,16.1382,5.9995,0.0174,-0.3837,16.1400,6.0000,10.0000,0.0000,16.1382,5.9995,0.0174,-0.3837,2.6094},
				{0.0200,12.7149,8.3619,16.2582,5.9998,0.0113,-0.3031,16.2600,6.0000,10.0000,0.0000,16.2582,5.9998,0.0113,-0.3031,2.6393},
				{0.0200,12.6091,8.4186,16.3782,5.9999,0.0068,-0.2231,16.3800,6.0000,10.0000,0.0000,16.3782,5.9999,0.0068,-0.2231,2.6580},
				{0.0200,12.5026,8.4738,16.4982,6.0000,0.0035,-0.1663,16.5000,6.0000,10.0000,0.0000,16.4982,6.0000,0.0035,-0.1663,2.6662},
				{0.0200,12.3959,8.5288,16.6182,6.0000,0.0008,-0.1356,16.6200,6.0000,10.0000,0.0000,16.6182,6.0000,0.0008,-0.1356,2.6643},
				{0.0200,12.2896,8.5845,16.7382,6.0000,-0.0018,-0.1297,16.7400,6.0000,10.0000,0.0000,16.7382,6.0000,-0.0018,-0.1297,2.6522},
				{0.0200,12.1843,8.6420,16.8582,5.9999,-0.0048,-0.1486,16.8600,6.0000,10.0000,0.0000,16.8582,5.9999,-0.0048,-0.1486,2.6292},
				{0.0200,12.0807,8.7025,16.9781,5.9997,-0.0087,-0.1951,16.9800,6.0000,10.0000,0.0000,16.9781,5.9997,-0.0087,-0.1951,2.5942},
				{0.0200,11.9797,8.7673,17.0981,5.9994,-0.0141,-0.2727,17.1000,6.0000,10.0000,0.0000,17.0981,5.9994,-0.0141,-0.2727,2.5457},
				{0.0200,11.8825,8.8376,17.2181,5.9990,-0.0216,-0.3763,17.2200,6.0000,10.0000,0.0000,17.2181,5.9990,-0.0216,-0.3763,2.4818},
				{0.0200,11.7907,8.9148,17.3381,5.9984,-0.0310,-0.4695,17.3400,6.0000,10.0000,0.0000,17.3381,5.9984,-0.0310,-0.4695,2.4008},
				{0.0200,11.7061,8.9999,17.4580,5.9976,-0.0399,-0.4451,17.4600,6.0000,10.0000,0.0000,17.4580,5.9976,-0.0399,-0.4451,2.3021},
				{0.0200,11.6312,9.0935,17.5780,5.9967,-0.0424,-0.1217,17.5800,6.0000,10.0000,0.0000,17.5780,5.9967,-0.0424,-0.1217,2.1875},
				{0.0200,11.5680,9.1955,17.6979,5.9961,-0.0307,0.5829,17.7000,6.0000,10.0000,0.0000,17.6979,5.9961,-0.0307,0.5829,2.0627},
				{0.0200,11.5182,9.3045,17.8178,5.9960,-0.0043,1.3185,17.8200,6.0000,10.0000,0.0000,17.8178,5.9960,-0.0043,1.3185,1.9365},
				{0.0200,11.4821,9.4189,17.9377,5.9965,0.0244,1.4350,17.9400,6.0000,10.0000,0.0000,17.9377,5.9965,0.0244,1.4350,1.8183},
				{0.0200,11.4589,9.5366,18.0577,5.9973,0.0407,0.8156,18.0600,6.0000,10.0000,0.0000,18.0577,5.9973,0.0407,0.8156,1.7146},
				{0.0200,11.4471,9.6560,18.1776,5.9981,0.0417,0.0511,18.1800,6.0000,10.0000,0.0000,18.1776,5.9981,0.0417,0.0511,1.6285},
				{0.0200,11.4444,9.7759,18.2976,5.9988,0.0341,-0.3791,18.3000,6.0000,10.0000,0.0000,18.2976,5.9988,0.0341,-0.3791,1.5600},
				{0.0200,11.4490,9.8958,18.4176,5.9993,0.0247,-0.4696,18.4200,6.0000,10.0000,0.0000,18.4176,5.9993,0.0247,-0.4696,1.5079},
				{0.0200,11.4589,10.0154,18.5376,5.9997,0.0167,-0.4016,18.5400,6.0000,10.0000,0.0000,18.5376,5.9997,0.0167,-0.4016,1.4708},
				{0.0200,11.4724,10.1347,18.6576,5.9999,0.0105,-0.3073,18.6600,6.0000,10.0000,0.0000,18.6576,5.9999,0.0105,-0.3073,1.4476},
				{0.0200,11.4878,10.2537,18.7776,6.0000,0.0056,-0.2460,18.7800,6.0000,10.0000,0.0000,18.7776,6.0000,0.0056,-0.2460,1.4384},
				{0.0200,11.5037,10.3726,18.8976,6.0000,0.0011,-0.2255,18.9000,6.0000,10.0000,0.0000,18.8976,6.0000,0.0011,-0.2255,1.4373},
				{0.0200,11.5199,10.4915,19.0176,6.0000,-0.0001,-0.0623,19.0200,6.0000,10.0000,0.0000,19.0176,6.0000,-0.0001,-0.0623,1.4338},
				{0.0200,11.5366,10.6103,19.1376,6.0000,-0.0004,-0.0109,19.1400,6.0000,10.0000,0.0000,19.1376,6.0000,-0.0004,-0.0109,1.4274},
				{0.0200,11.5543,10.7290,19.2576,6.0000,-0.0007,-0.0147,19.2600,6.0000,10.0000,0.0000,19.2576,6.0000,-0.0007,-0.0147,1.4178},
				{0.0200,11.5733,10.8475,19.3776,6.0000,-0.0011,-0.0199,19.3800,6.0000,10.0000,0.0000,19.3776,6.0000,-0.0011,-0.0199,1.4044},
				{0.0200,11.5942,10.9657,19.4976,5.9999,-0.0016,-0.0272,19.5000,6.0000,10.0000,0.0000,19.4976,5.9999,-0.0016,-0.0272,1.3870},
				{0.0200,11.6174,11.0834,19.6176,5.9999,-0.0023,-0.0375,19.6200,6.0000,10.0000,0.0000,19.6176,5.9999,-0.0023,-0.0375,1.3648},
				{0.0200,11.6435,11.2005,19.7376,5.9998,-0.0034,-0.0520,19.7400,6.0000,10.0000,0.0000,19.7376,5.9998,-0.0034,-0.0520,1.3371},
				{0.0200,11.6732,11.3168,19.8576,5.9997,-0.0048,-0.0721,19.8600,6.0000,10.0000,0.0000,19.8576,5.9997,-0.0048,-0.0721,1.3032},
				{0.0200,11.7072,11.4319,19.9776,5.9996,-0.0068,-0.0990,19.9800,6.0000,10.0000,0.0000,19.9776,5.9996,-0.0068,-0.0990,1.2620},
				{0.0200,11.7464,11.5453,20.0976,5.9994,-0.0095,-0.1326,20.1000,6.0000,10.0000,0.0000,20.0976,5.9994,-0.0095,-0.1326,1.2125},
				{0.0200,11.7917,11.6564,20.2175,5.9991,-0.0128,-0.1685,20.2200,6.0000,10.0000,0.0000,20.2175,5.9991,-0.0128,-0.1685,1.1535},
				{0.0200,11.8440,11.7643,20.3375,5.9988,-0.0167,-0.1935,20.3400,6.0000,10.0000,0.0000,20.3375,5.9988,-0.0167,-0.1935,1.0841},
				{0.0200,11.9042,11.8681,20.4575,5.9984,-0.0203,-0.1803,20.4600,6.0000,10.0000,0.0000,20.4575,5.9984,-0.0203,-0.1803,1.0039},
				{0.0200,11.9731,11.9663,20.5775,5.9979,-0.0221,-0.0887,20.5800,6.0000,10.0000,0.0000,20.5775,5.9979,-0.0221,-0.0887,0.9134},
				{0.0200,12.0509,12.0576,20.6974,5.9976,-0.0199,0.1089,20.7000,6.0000,10.0000,0.0000,20.6974,5.9976,-0.0199,0.1089,0.8145},
				{0.0200,12.1376,12.1405,20.8173,5.9973,-0.0124,0.3752,20.8200,6.0000,10.0000,0.0000,20.8173,5.9973,-0.0124,0.3752,0.7107},
				{0.0200,12.2325,12.2139,20.9373,5.9973,-0.0007,0.5825,20.9400,6.0000,10.0000,0.0000,20.9373,5.9973,-0.0007,0.5825,0.6066},
				{0.0200,12.3344,12.2772,21.0572,5.9975,0.0111,0.5946,21.0600,6.0000,10.0000,0.0000,21.0572,5.9975,0.0111,0.5946,0.5069},
				{0.0200,12.4418,12.3305,21.1772,5.9979,0.0192,0.4036,21.1800,6.0000,10.0000,0.0000,21.1772,5.9979,0.0192,0.4036,0.4151},
				{0.0200,12.5535,12.3742,21.2972,5.9983,0.0220,0.1383,21.3000,6.0000,10.0000,0.0000,21.2972,5.9983,0.0220,0.1383,0.3335},
				{0.0200,12.6682,12.4094,21.4171,5.9987,0.0206,-0.0680,21.4200,6.0000,10.0000,0.0000,21.4171,5.9987,0.0206,-0.0680,0.2628},
				{0.0200,12.7850,12.4369,21.5371,5.9991,0.0172,-0.1697,21.5400,6.0000,10.0000,0.0000,21.5371,5.9991,0.0172,-0.1697,0.2025},
				{0.0200,12.9031,12.4580,21.6571,5.9994,0.0134,-0.1900,21.6600,6.0000,10.0000,0.0000,21.6571,5.9994,0.0134,-0.1900,0.1519},
				{0.0200,13.0221,12.4736,21.7771,5.9996,0.0101,-0.1688,21.7800,6.0000,10.0000,0.0000,21.7771,5.9996,0.0101,-0.1688,0.1100},
				{0.0200,13.1416,12.4846,21.8971,5.9997,0.0074,-0.1347,21.9000,6.0000,10.0000,0.0000,21.8971,5.9997,0.0074,-0.1347,0.0759},
				{0.0200,13.2614,12.4920,22.0171,5.9998,0.0053,-0.1020,22.0200,6.0000,10.0000,0.0000,22.0171,5.9998,0.0053,-0.1020,0.0486},
				{0.0200,13.3813,12.4966,22.1371,5.9999,0.0038,-0.0760,22.1400,6.0000,10.0000,0.0000,22.1371,5.9999,0.0038,-0.0760,0.0277},
				{0.0200,13.5013,12.4989,22.2571,5.9999,0.0027,-0.0573,22.2600,6.0000,10.0000,0.0000,22.2571,5.9999,0.0027,-0.0573,0.0127},
				{0.0200,13.6213,12.4999,22.3771,6.0000,0.0017,-0.0457,22.3800,6.0000,10.0000,0.0000,22.3771,6.0000,0.0017,-0.0457,0.0035},
				{0.0200,13.7413,12.5000,22.4971,6.0000,0.0009,-0.0407,22.5000,6.0000,10.0000,0.0000,22.4971,6.0000,0.0009,-0.0407,0.0000},
				{0.0200,13.8613,12.5000,22.6171,6.0000,0.0002,-0.0383,22.6200,6.0000,10.0000,0.0000,22.6171,6.0000,0.0002,-0.0383,0.0000},
				{0.0200,13.9853,12.5000,22.7411,6.2000,10.0000,499.9922,22.7440,6.2000,10.0000,0.0000,22.7411,6.2000,10.0000,499.9922,0.0000},
				{0.0200,14.1133,12.5000,22.8691,6.4000,10.0000,0.0000,22.8720,6.4000,10.0000,0.0000,22.8691,6.4000,10.0000,0.0000,0.0000},
				{0.0200,14.2453,12.5000,23.0011,6.6000,10.0000,0.0000,23.0040,6.6000,10.0000,0.0000,23.0011,6.6000,10.0000,0.0000,0.0000},
				{0.0200,14.3813,12.5000,23.1371,6.8000,10.0000,-0.0000,23.1400,6.8000,10.0000,0.0000,23.1371,6.8000,10.0000,-0.0000,0.0000},
				{0.0200,14.5213,12.5000,23.2771,7.0000,10.0000,0.0000,23.2800,7.0000,10.0000,0.0000,23.2771,7.0000,10.0000,0.0000,0.0000},
				{0.0200,14.6653,12.5000,23.4211,7.2000,10.0000,0.0000,23.4240,7.2000,10.0000,0.0000,23.4211,7.2000,10.0000,0.0000,0.0000},
				{0.0200,14.8133,12.5000,23.5691,7.4000,10.0000,0.0000,23.5720,7.4000,10.0000,0.0000,23.5691,7.4000,10.0000,0.0000,0.0000},
				{0.0200,14.9653,12.5000,23.7211,7.6000,10.0000,0.0000,23.7240,7.6000,10.0000,0.0000,23.7211,7.6000,10.0000,0.0000,0.0000},
				{0.0200,15.1213,12.5000,23.8771,7.8000,10.0000,-0.0000,23.8800,7.8000,10.0000,0.0000,23.8771,7.8000,10.0000,-0.0000,0.0000},
				{0.0200,15.2813,12.5000,24.0371,8.0000,10.0000,0.0000,24.0400,8.0000,10.0000,0.0000,24.0371,8.0000,10.0000,0.0000,0.0000},
				{0.0200,15.4453,12.5000,24.2011,8.2000,10.0000,0.0000,24.2040,8.2000,10.0000,0.0000,24.2011,8.2000,10.0000,0.0000,0.0000},
				{0.0200,15.6133,12.5000,24.3691,8.4000,10.0000,-0.0000,24.3720,8.4000,10.0000,0.0000,24.3691,8.4000,10.0000,-0.0000,0.0000},
				{0.0200,15.7853,12.5000,24.5411,8.6000,10.0000,-0.0000,24.5440,8.6000,10.0000,0.0000,24.5411,8.6000,10.0000,-0.0000,0.0000},
				{0.0200,15.9613,12.5000,24.7171,8.8000,10.0000,-0.0000,24.7200,8.8000,10.0000,0.0000,24.7171,8.8000,10.0000,-0.0000,0.0000},
				{0.0200,16.1413,12.5000,24.8971,9.0000,10.0000,0.0000,24.9000,9.0000,10.0000,0.0000,24.8971,9.0000,10.0000,0.0000,0.0000},
				{0.0200,16.3253,12.5000,25.0811,9.2000,10.0000,-0.0000,25.0840,9.2000,10.0000,0.0000,25.0811,9.2000,10.0000,-0.0000,0.0000},
				{0.0200,16.5133,12.5000,25.2691,9.4000,10.0000,-0.0000,25.2720,9.4000,10.0000,0.0000,25.2691,9.4000,10.0000,-0.0000,0.0000},
				{0.0200,16.7053,12.5000,25.4611,9.6000,10.0000,0.0000,25.4640,9.6000,10.0000,0.0000,25.4611,9.6000,10.0000,0.0000,0.0000},
				{0.0200,16.9013,12.5000,25.6571,9.8000,10.0000,0.0000,25.6600,9.8000,10.0000,0.0000,25.6571,9.8000,10.0000,0.0000,0.0000},
				{0.0200,17.1013,12.5000,25.8571,10.0000,10.0000,-0.0000,25.8600,10.0000,10.0000,0.0000,25.8571,10.0000,10.0000,-0.0000,0.0000},
				{0.0200,17.3053,12.5000,26.0611,10.2000,10.0000,0.0000,26.0640,10.2000,10.0000,0.0000,26.0611,10.2000,10.0000,0.0000,0.0000},
				{0.0200,17.5133,12.5000,26.2691,10.4000,10.0000,-0.0000,26.2720,10.4000,10.0000,0.0000,26.2691,10.4000,10.0000,-0.0000,0.0000},
				{0.0200,17.7253,12.5000,26.4811,10.6000,10.0000,0.0000,26.4840,10.6000,10.0000,0.0000,26.4811,10.6000,10.0000,0.0000,0.0000},
				{0.0200,17.9413,12.5000,26.6971,10.8000,10.0000,-0.0000,26.7000,10.8000,10.0000,0.0000,26.6971,10.8000,10.0000,-0.0000,0.0000},
				{0.0200,18.1613,12.5000,26.9171,11.0000,10.0000,0.0000,26.9200,11.0000,10.0000,0.0000,26.9171,11.0000,10.0000,0.0000,0.0000},
				{0.0200,18.3853,12.5000,27.1411,11.2000,10.0000,0.0000,27.1440,11.2000,10.0000,0.0000,27.1411,11.2000,10.0000,0.0000,0.0000},
				{0.0200,18.6133,12.5000,27.3691,11.4000,10.0000,0.0000,27.3720,11.4000,10.0000,0.0000,27.3691,11.4000,10.0000,0.0000,0.0000},
				{0.0200,18.8453,12.5000,27.6011,11.6000,10.0000,-0.0000,27.6040,11.6000,10.0000,0.0000,27.6011,11.6000,10.0000,-0.0000,0.0000},
				{0.0200,19.0813,12.5000,27.8371,11.8000,10.0000,0.0000,27.8400,11.8000,10.0000,0.0000,27.8371,11.8000,10.0000,0.0000,0.0000},
				{0.0200,19.3213,12.5000,28.0771,12.0000,10.0000,0.0000,28.0800,12.0000,10.0000,0.0000,28.0771,12.0000,10.0000,0.0000,0.0000},
				{0.0200,19.5653,12.5000,28.3211,12.2000,10.0000,-0.0000,28.3240,12.2000,10.0000,0.0000,28.3211,12.2000,10.0000,-0.0000,0.0000},
				{0.0200,19.8133,12.5000,28.5691,12.4000,10.0000,0.0000,28.5720,12.4000,10.0000,0.0000,28.5691,12.4000,10.0000,0.0000,0.0000},
				{0.0200,20.0653,12.5000,28.8211,12.6000,10.0000,-0.0000,28.8240,12.6000,10.0000,0.0000,28.8211,12.6000,10.0000,-0.0000,0.0000},
				{0.0200,20.3213,12.5000,29.0771,12.8000,10.0000,0.0000,29.0800,12.8000,10.0000,0.0000,29.0771,12.8000,10.0000,0.0000,0.0000},
				{0.0200,20.5813,12.5000,29.3371,13.0000,10.0000,-0.0000,29.3400,13.0000,10.0000,0.0000,29.3371,13.0000,10.0000,-0.0000,0.0000},
				{0.0200,20.8453,12.5000,29.6011,13.2000,10.0000,0.0000,29.6040,13.2000,10.0000,0.0000,29.6011,13.2000,10.0000,0.0000,0.0000},
				{0.0200,21.1133,12.5000,29.8691,13.4000,10.0000,0.0000,29.8720,13.4000,10.0000,0.0000,29.8691,13.4000,10.0000,0.0000,0.0000},
				{0.0200,21.3773,12.5000,30.1331,13.2000,-10.0000,-1000.0000,30.1360,13.2000,-10.0000,0.0000,30.1331,13.2000,-10.0000,-1000.0000,0.0000},
				{0.0200,21.6373,12.5000,30.3931,13.0000,-10.0000,0.0000,30.3960,13.0000,-10.0000,0.0000,30.3931,13.0000,-10.0000,0.0000,0.0000},
				{0.0200,21.8933,12.5000,30.6491,12.8000,-10.0000,0.0000,30.6520,12.8000,-10.0000,0.0000,30.6491,12.8000,-10.0000,0.0000,0.0000},
				{0.0200,22.1453,12.5000,30.9011,12.6000,-10.0000,0.0000,30.9040,12.6000,-10.0000,0.0000,30.9011,12.6000,-10.0000,0.0000,0.0000},
				{0.0200,22.3933,12.5000,31.1491,12.4000,-10.0000,-0.0000,31.1520,12.4000,-10.0000,0.0000,31.1491,12.4000,-10.0000,-0.0000,0.0000},
				{0.0200,22.6373,12.5000,31.3931,12.2000,-10.0000,-0.0000,31.3960,12.2000,-10.0000,0.0000,31.3931,12.2000,-10.0000,-0.0000,0.0000},
				{0.0200,22.8773,12.5000,31.6331,12.0000,-10.0000,-0.0000,31.6360,12.0000,-10.0000,0.0000,31.6331,12.0000,-10.0000,-0.0000,0.0000},
				{0.0200,23.1133,12.5000,31.8691,11.8000,-10.0000,0.0000,31.8720,11.8000,-10.0000,0.0000,31.8691,11.8000,-10.0000,0.0000,0.0000},
				{0.0200,23.3453,12.5000,32.1011,11.6000,-10.0000,-0.0000,32.1040,11.6000,-10.0000,0.0000,32.1011,11.6000,-10.0000,-0.0000,0.0000},
				{0.0200,23.5733,12.5000,32.3291,11.4000,-10.0000,0.0000,32.3320,11.4000,-10.0000,0.0000,32.3291,11.4000,-10.0000,0.0000,0.0000},
				{0.0200,23.7973,12.5000,32.5531,11.2000,-10.0000,-0.0000,32.5560,11.2000,-10.0000,0.0000,32.5531,11.2000,-10.0000,-0.0000,0.0000},
				{0.0200,24.0173,12.5000,32.7731,11.0000,-10.0000,0.0000,32.7760,11.0000,-10.0000,0.0000,32.7731,11.0000,-10.0000,0.0000,0.0000},
				{0.0200,24.2333,12.5000,32.9891,10.8000,-10.0000,0.0000,32.9920,10.8000,-10.0000,0.0000,32.9891,10.8000,-10.0000,0.0000,0.0000},
				{0.0200,24.4453,12.5000,33.2011,10.6000,-10.0000,0.0000,33.2040,10.6000,-10.0000,0.0000,33.2011,10.6000,-10.0000,0.0000,0.0000},
				{0.0200,24.6533,12.5000,33.4091,10.4000,-10.0000,-0.0000,33.4120,10.4000,-10.0000,0.0000,33.4091,10.4000,-10.0000,-0.0000,0.0000},
				{0.0200,24.8573,12.5000,33.6131,10.2000,-10.0000,0.0000,33.6160,10.2000,-10.0000,0.0000,33.6131,10.2000,-10.0000,0.0000,0.0000},
				{0.0200,25.0573,12.5000,33.8131,10.0000,-10.0000,0.0000,33.8160,10.0000,-10.0000,0.0000,33.8131,10.0000,-10.0000,0.0000,0.0000},
				{0.0200,25.2533,12.5000,34.0091,9.8000,-10.0000,-0.0000,34.0120,9.8000,-10.0000,0.0000,34.0091,9.8000,-10.0000,-0.0000,0.0000},
				{0.0200,25.4453,12.5000,34.2011,9.6000,-10.0000,0.0000,34.2040,9.6000,-10.0000,0.0000,34.2011,9.6000,-10.0000,0.0000,0.0000},
				{0.0200,25.6333,12.5000,34.3891,9.4000,-10.0000,-0.0000,34.3920,9.4000,-10.0000,0.0000,34.3891,9.4000,-10.0000,-0.0000,0.0000},
				{0.0200,25.8173,12.5000,34.5731,9.2000,-10.0000,-0.0000,34.5760,9.2000,-10.0000,0.0000,34.5731,9.2000,-10.0000,-0.0000,0.0000},
				{0.0200,25.9973,12.5000,34.7531,9.0000,-10.0000,0.0000,34.7560,9.0000,-10.0000,0.0000,34.7531,9.0000,-10.0000,0.0000,0.0000},
				{0.0200,26.1733,12.5000,34.9291,8.8000,-10.0000,-0.0000,34.9320,8.8000,-10.0000,0.0000,34.9291,8.8000,-10.0000,-0.0000,0.0000},
				{0.0200,26.3453,12.5000,35.1011,8.6000,-10.0000,0.0000,35.1040,8.6000,-10.0000,0.0000,35.1011,8.6000,-10.0000,0.0000,0.0000},
				{0.0200,26.5133,12.5000,35.2691,8.4000,-10.0000,-0.0000,35.2720,8.4000,-10.0000,0.0000,35.2691,8.4000,-10.0000,-0.0000,0.0000},
				{0.0200,26.6773,12.5000,35.4331,8.2000,-10.0000,0.0000,35.4360,8.2000,-10.0000,0.0000,35.4331,8.2000,-10.0000,0.0000,0.0000},
				{0.0200,26.8373,12.5000,35.5931,8.0000,-10.0000,-0.0000,35.5960,8.0000,-10.0000,0.0000,35.5931,8.0000,-10.0000,-0.0000,0.0000},
				{0.0200,26.9933,12.5000,35.7491,7.8000,-10.0000,-0.0000,35.7520,7.8000,-10.0000,0.0000,35.7491,7.8000,-10.0000,-0.0000,0.0000},
				{0.0200,27.1453,12.5000,35.9011,7.6000,-10.0000,0.0000,35.9040,7.6000,-10.0000,0.0000,35.9011,7.6000,-10.0000,0.0000,0.0000},
				{0.0200,27.2933,12.5000,36.0491,7.4000,-10.0000,-0.0000,36.0520,7.4000,-10.0000,0.0000,36.0491,7.4000,-10.0000,-0.0000,0.0000},
				{0.0200,27.4373,12.5000,36.1931,7.2000,-10.0000,-0.0000,36.1960,7.2000,-10.0000,0.0000,36.1931,7.2000,-10.0000,-0.0000,0.0000},
				{0.0200,27.5773,12.5000,36.3331,7.0000,-10.0000,0.0000,36.3360,7.0000,-10.0000,0.0000,36.3331,7.0000,-10.0000,0.0000,0.0000},
				{0.0200,27.7133,12.5000,36.4691,6.8000,-10.0000,-0.0000,36.4720,6.8000,-10.0000,0.0000,36.4691,6.8000,-10.0000,-0.0000,0.0000},
				{0.0200,27.8453,12.5000,36.6011,6.6000,-10.0000,-0.0000,36.6040,6.6000,-10.0000,0.0000,36.6011,6.6000,-10.0000,-0.0000,0.0000},
				{0.0200,27.9733,12.5000,36.7291,6.4000,-10.0000,0.0000,36.7320,6.4000,-10.0000,0.0000,36.7291,6.4000,-10.0000,0.0000,0.0000},
				{0.0200,28.0973,12.5000,36.8531,6.2000,-10.0000,0.0000,36.8560,6.2000,-10.0000,0.0000,36.8531,6.2000,-10.0000,0.0000,0.0000},
				{0.0200,28.2173,12.5000,36.9731,6.0000,-10.0000,-0.0000,36.9760,6.0000,-10.0000,0.0000,36.9731,6.0000,-10.0000,-0.0000,0.0000},
				{0.0200,28.3333,12.5000,37.0891,5.8000,-10.0000,0.0000,37.0920,5.8000,-10.0000,0.0000,37.0891,5.8000,-10.0000,0.0000,0.0000},
				{0.0200,28.4453,12.5000,37.2011,5.6000,-10.0000,0.0000,37.2040,5.6000,-10.0000,0.0000,37.2011,5.6000,-10.0000,0.0000,0.0000},
				{0.0200,28.5533,12.5000,37.3091,5.4000,-10.0000,-0.0000,37.3120,5.4000,-10.0000,0.0000,37.3091,5.4000,-10.0000,-0.0000,0.0000},
				{0.0200,28.6573,12.5000,37.4131,5.2000,-10.0000,0.0000,37.4160,5.2000,-10.0000,0.0000,37.4131,5.2000,-10.0000,0.0000,0.0000},
				{0.0200,28.7573,12.5000,37.5131,5.0000,-10.0000,-0.0000,37.5160,5.0000,-10.0000,0.0000,37.5131,5.0000,-10.0000,-0.0000,0.0000},
				{0.0200,28.8533,12.5000,37.6091,4.8000,-10.0000,-0.0000,37.6120,4.8000,-10.0000,0.0000,37.6091,4.8000,-10.0000,-0.0000,0.0000},
				{0.0200,28.9453,12.5000,37.7011,4.6000,-10.0000,0.0000,37.7040,4.6000,-10.0000,0.0000,37.7011,4.6000,-10.0000,0.0000,0.0000},
				{0.0200,29.0333,12.5000,37.7891,4.4000,-10.0000,-0.0000,37.7920,4.4000,-10.0000,0.0000,37.7891,4.4000,-10.0000,-0.0000,0.0000},
				{0.0200,29.1173,12.5000,37.8731,4.2000,-10.0000,0.0000,37.8760,4.2000,-10.0000,0.0000,37.8731,4.2000,-10.0000,0.0000,0.0000},
				{0.0200,29.1973,12.5000,37.9531,4.0000,-10.0000,-0.0000,37.9560,4.0000,-10.0000,0.0000,37.9531,4.0000,-10.0000,-0.0000,0.0000},
				{0.0200,29.2733,12.5000,38.0291,3.8000,-10.0000,0.0000,38.0320,3.8000,-10.0000,0.0000,38.0291,3.8000,-10.0000,0.0000,0.0000},
				{0.0200,29.3453,12.5000,38.1011,3.6000,-10.0000,-0.0000,38.1040,3.6000,-10.0000,0.0000,38.1011,3.6000,-10.0000,-0.0000,0.0000},
				{0.0200,29.4133,12.5000,38.1691,3.4000,-10.0000,0.0000,38.1720,3.4000,-10.0000,0.0000,38.1691,3.4000,-10.0000,0.0000,0.0000},
				{0.0200,29.4773,12.5000,38.2331,3.2000,-10.0000,0.0000,38.2360,3.2000,-10.0000,0.0000,38.2331,3.2000,-10.0000,0.0000,0.0000},
				{0.0200,29.5373,12.5000,38.2931,3.0000,-10.0000,0.0000,38.2960,3.0000,-10.0000,0.0000,38.2931,3.0000,-10.0000,0.0000,0.0000},
				{0.0200,29.5933,12.5000,38.3491,2.8000,-10.0000,0.0000,38.3520,2.8000,-10.0000,0.0000,38.3491,2.8000,-10.0000,0.0000,0.0000},
				{0.0200,29.6453,12.5000,38.4011,2.6000,-10.0000,0.0000,38.4040,2.6000,-10.0000,0.0000,38.4011,2.6000,-10.0000,0.0000,0.0000},
				{0.0200,29.6933,12.5000,38.4491,2.4000,-10.0000,0.0000,38.4520,2.4000,-10.0000,0.0000,38.4491,2.4000,-10.0000,0.0000,0.0000},
				{0.0200,29.7373,12.5000,38.4931,2.2000,-10.0000,-0.0000,38.4960,2.2000,-10.0000,0.0000,38.4931,2.2000,-10.0000,-0.0000,0.0000},
				{0.0200,29.7773,12.5000,38.5331,2.0000,-10.0000,0.0000,38.5360,2.0000,-10.0000,0.0000,38.5331,2.0000,-10.0000,0.0000,0.0000},
				{0.0200,29.8133,12.5000,38.5691,1.8000,-10.0000,0.0000,38.5720,1.8000,-10.0000,0.0000,38.5691,1.8000,-10.0000,0.0000,0.0000},
				{0.0200,29.8453,12.5000,38.6011,1.6000,-10.0000,-0.0000,38.6040,1.6000,-10.0000,0.0000,38.6011,1.6000,-10.0000,-0.0000,0.0000},
				{0.0200,29.8733,12.5000,38.6291,1.4000,-10.0000,0.0000,38.6320,1.4000,-10.0000,0.0000,38.6291,1.4000,-10.0000,0.0000,0.0000},
				{0.0200,29.8973,12.5000,38.6531,1.2000,-10.0000,-0.0000,38.6560,1.2000,-10.0000,0.0000,38.6531,1.2000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9173,12.5000,38.6731,1.0000,-10.0000,0.0000,38.6760,1.0000,-10.0000,0.0000,38.6731,1.0000,-10.0000,0.0000,0.0000},
				{0.0200,29.9333,12.5000,38.6891,0.8000,-10.0000,-0.0000,38.6920,0.8000,-10.0000,0.0000,38.6891,0.8000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9453,12.5000,38.7011,0.6000,-10.0000,0.0000,38.7040,0.6000,-10.0000,0.0000,38.7011,0.6000,-10.0000,0.0000,0.0000},
				{0.0200,29.9533,12.5000,38.7091,0.4000,-10.0000,-0.0000,38.7120,0.4000,-10.0000,0.0000,38.7091,0.4000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9573,12.5000,38.7131,0.2000,-10.0000,-0.0000,38.7160,0.2000,-10.0000,0.0000,38.7131,0.2000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9573,12.5000,38.7131,0.0000,-10.0000,0.0000,38.7160,-0.0000,-10.0000,0.0000,38.7131,0.0000,-10.0000,0.0000,0.0000},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}