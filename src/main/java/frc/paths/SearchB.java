package frc.paths;

import com.team319.trajectory.Path;

public class SearchB extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,1.2540,7.5000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,-0.0000},
				{0.0200,1.2620,7.5000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,-0.0000},
				{0.0200,1.2740,7.5000,0.0240,0.6000,10.0000,-0.0000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,-0.0000,-0.0000},
				{0.0200,1.2900,7.5000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,0.0000,-0.0000},
				{0.0200,1.3100,7.5000,0.0600,1.0000,10.0000,-0.0000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,-0.0000,-0.0001},
				{0.0200,1.3340,7.5000,0.0840,1.2000,10.0000,-0.0000,0.0840,1.2000,10.0000,0.0000,0.0840,1.2000,10.0000,-0.0000,-0.0002},
				{0.0200,1.3620,7.5000,0.1120,1.4000,10.0000,-0.0000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,-0.0000,-0.0003},
				{0.0200,1.3940,7.5000,0.1440,1.6000,10.0000,-0.0000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,-0.0000,-0.0005},
				{0.0200,1.4300,7.5000,0.1800,1.8000,10.0000,-0.0000,0.1800,1.8000,10.0000,0.0000,0.1800,1.8000,10.0000,-0.0000,-0.0008},
				{0.0200,1.4700,7.4999,0.2200,2.0000,10.0000,-0.0000,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,-0.0000,-0.0012},
				{0.0200,1.5140,7.4998,0.2640,2.2000,10.0000,-0.0000,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,-0.0000,-0.0018},
				{0.0200,1.5620,7.4997,0.3120,2.4000,10.0000,-0.0000,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,-0.0000,-0.0024},
				{0.0200,1.6140,7.4996,0.3640,2.6000,10.0000,-0.0000,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,-0.0000,-0.0033},
				{0.0200,1.6700,7.4994,0.4200,2.8000,10.0000,-0.0000,0.4200,2.8000,10.0000,0.0000,0.4200,2.8000,10.0000,-0.0000,-0.0044},
				{0.0200,1.7300,7.4991,0.4800,3.0000,10.0000,-0.0001,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,-0.0001,-0.0056},
				{0.0200,1.7940,7.4987,0.5440,3.2000,10.0000,-0.0001,0.5440,3.2000,10.0000,0.0000,0.5440,3.2000,10.0000,-0.0001,-0.0072},
				{0.0200,1.8620,7.4981,0.6120,3.4000,10.0000,-0.0001,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,10.0000,-0.0001,-0.0090},
				{0.0200,1.9340,7.4974,0.6840,3.6000,10.0000,-0.0001,0.6840,3.6000,10.0000,0.0000,0.6840,3.6000,10.0000,-0.0001,-0.0111},
				{0.0200,2.0100,7.4965,0.7600,3.8000,10.0000,-0.0002,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,10.0000,-0.0002,-0.0136},
				{0.0200,2.0900,7.4953,0.8400,4.0000,10.0000,-0.0002,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,10.0000,-0.0002,-0.0164},
				{0.0200,2.1740,7.4938,0.9240,4.2000,10.0000,-0.0003,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,10.0000,-0.0003,-0.0196},
				{0.0200,2.2619,7.4919,1.0120,4.4000,10.0000,-0.0003,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,10.0000,-0.0003,-0.0233},
				{0.0200,2.3539,7.4895,1.1040,4.6000,10.0000,-0.0004,1.1040,4.6000,10.0000,0.0000,1.1040,4.6000,10.0000,-0.0004,-0.0273},
				{0.0200,2.4499,7.4867,1.2000,4.8000,10.0000,-0.0004,1.2000,4.8000,10.0000,0.0000,1.2000,4.8000,10.0000,-0.0004,-0.0319},
				{0.0200,2.5498,7.4833,1.3000,5.0000,9.9999,-0.0005,1.3000,5.0000,10.0000,0.0000,1.3000,5.0000,9.9999,-0.0005,-0.0369},
				{0.0200,2.6537,7.4791,1.4040,5.2000,9.9999,-0.0005,1.4040,5.2000,10.0000,0.0000,1.4040,5.2000,9.9999,-0.0005,-0.0424},
				{0.0200,2.7616,7.4743,1.5120,5.4000,9.9999,-0.0006,1.5120,5.4000,10.0000,0.0000,1.5120,5.4000,9.9999,-0.0006,-0.0484},
				{0.0200,2.8735,7.4685,1.6240,5.6000,9.9999,-0.0006,1.6240,5.6000,10.0000,0.0000,1.6240,5.6000,9.9999,-0.0006,-0.0549},
				{0.0200,2.9893,7.4617,1.7400,5.8000,9.9999,-0.0007,1.7400,5.8000,10.0000,0.0000,1.7400,5.8000,9.9999,-0.0007,-0.0620},
				{0.0200,3.1090,7.4538,1.8600,6.0000,9.9999,-0.0007,1.8600,6.0000,10.0000,0.0000,1.8600,6.0000,9.9999,-0.0007,-0.0696},
				{0.0200,3.2327,7.4447,1.9840,6.2000,9.9999,-0.0007,1.9840,6.2000,10.0000,0.0000,1.9840,6.2000,9.9999,-0.0007,-0.0777},
				{0.0200,3.3602,7.4342,2.1120,6.4000,9.9999,-0.0007,2.1120,6.4000,10.0000,0.0000,2.1120,6.4000,9.9999,-0.0007,-0.0864},
				{0.0200,3.4917,7.4222,2.2440,6.6000,9.9998,-0.0006,2.2440,6.6000,10.0000,0.0000,2.2440,6.6000,9.9998,-0.0006,-0.0956},
				{0.0200,3.6270,7.4086,2.3800,6.8000,9.9998,-0.0005,2.3800,6.8000,10.0000,0.0000,2.3800,6.8000,9.9998,-0.0005,-0.1053},
				{0.0200,3.7662,7.3932,2.5200,7.0000,9.9998,-0.0004,2.5200,7.0000,10.0000,0.0000,2.5200,7.0000,9.9998,-0.0004,-0.1154},
				{0.0200,3.9091,7.3758,2.6640,7.2000,9.9998,-0.0003,2.6640,7.2000,10.0000,0.0000,2.6640,7.2000,9.9998,-0.0003,-0.1260},
				{0.0200,4.0558,7.3564,2.8120,7.4000,9.9998,-0.0001,2.8120,7.4000,10.0000,0.0000,2.8120,7.4000,9.9998,-0.0001,-0.1370},
				{0.0200,4.2063,7.3348,2.9640,7.6000,9.9998,0.0001,2.9640,7.6000,10.0000,0.0000,2.9640,7.6000,9.9998,0.0001,-0.1484},
				{0.0200,4.3604,7.3108,3.1200,7.8000,9.9998,0.0004,3.1200,7.8000,10.0000,0.0000,3.1200,7.8000,9.9998,0.0004,-0.1601},
				{0.0200,4.5182,7.2844,3.2800,8.0000,9.9998,0.0007,3.2800,8.0000,10.0000,0.0000,3.2800,8.0000,9.9998,0.0007,-0.1721},
				{0.0200,4.6796,7.2553,3.4440,8.1999,9.9999,0.0010,3.4440,8.2000,10.0000,0.0000,3.4440,8.1999,9.9999,0.0010,-0.1842},
				{0.0200,4.8446,7.2235,3.6120,8.3999,9.9999,0.0013,3.6120,8.4000,10.0000,0.0000,3.6120,8.3999,9.9999,0.0013,-0.1965},
				{0.0200,5.0131,7.1889,3.7840,8.5999,9.9999,0.0015,3.7840,8.6000,10.0000,0.0000,3.7840,8.5999,9.9999,0.0015,-0.2088},
				{0.0200,5.1850,7.1513,3.9600,8.7999,10.0000,0.0018,3.9600,8.8000,10.0000,0.0000,3.9600,8.7999,10.0000,0.0018,-0.2211},
				{0.0200,5.3604,7.1108,4.1400,8.9999,10.0000,0.0020,4.1400,9.0000,10.0000,0.0000,4.1400,8.9999,10.0000,0.0020,-0.2333},
				{0.0200,5.5391,7.0672,4.3240,9.1999,10.0000,0.0022,4.3240,9.2000,10.0000,0.0000,4.3240,9.1999,10.0000,0.0022,-0.2453},
				{0.0200,5.7212,7.0204,4.5120,9.3999,10.0001,0.0023,4.5120,9.4000,10.0000,0.0000,4.5120,9.3999,10.0001,0.0023,-0.2569},
				{0.0200,5.9067,6.9706,4.7040,9.5999,10.0001,0.0023,4.7040,9.6000,10.0000,0.0000,4.7040,9.5999,10.0001,0.0023,-0.2682},
				{0.0200,6.0954,6.9176,4.9000,9.8000,10.0002,0.0022,4.9000,9.8000,10.0000,0.0000,4.9000,9.8000,10.0002,0.0022,-0.2789},
				{0.0200,6.2874,6.8616,5.1000,10.0000,10.0002,0.0020,5.1000,10.0000,10.0000,0.0000,5.1000,10.0000,10.0002,0.0020,-0.2891},
				{0.0200,6.4826,6.8025,5.3040,10.2000,10.0002,0.0018,5.3040,10.2000,10.0000,0.0000,5.3040,10.2000,10.0002,0.0018,-0.2986},
				{0.0200,6.6811,6.7404,5.5120,10.4000,10.0003,0.0014,5.5120,10.4000,10.0000,0.0000,5.5120,10.4000,10.0003,0.0014,-0.3072},
				{0.0200,6.8829,6.6755,5.7240,10.6000,10.0003,0.0009,5.7240,10.6000,10.0000,0.0000,5.7240,10.6000,10.0003,0.0009,-0.3150},
				{0.0200,7.0881,6.6079,5.9400,10.8000,10.0003,0.0003,5.9400,10.8000,10.0000,0.0000,5.9400,10.8000,10.0003,0.0003,-0.3218},
				{0.0200,7.2966,6.5377,6.1600,11.0000,10.0003,-0.0004,6.1600,11.0000,10.0000,0.0000,6.1600,11.0000,10.0003,-0.0004,-0.3275},
				{0.0200,7.5085,6.4651,6.3840,11.2000,10.0003,-0.0012,6.3840,11.2000,10.0000,0.0000,6.3840,11.2000,10.0003,-0.0012,-0.3320},
				{0.0200,7.7239,6.3904,6.6120,11.4000,10.0002,-0.0021,6.6120,11.4000,10.0000,0.0000,6.6120,11.4000,10.0002,-0.0021,-0.3352},
				{0.0200,7.9429,6.3139,6.8440,11.6000,10.0002,-0.0031,6.8440,11.6000,10.0000,0.0000,6.8440,11.6000,10.0002,-0.0031,-0.3371},
				{0.0200,8.1656,6.2357,7.0800,11.8000,10.0001,-0.0041,7.0800,11.8000,10.0000,0.0000,7.0800,11.8000,10.0001,-0.0041,-0.3376},
				{0.0200,8.3921,6.1563,7.3200,12.0000,10.0000,-0.0052,7.3200,12.0000,10.0000,0.0000,7.3200,12.0000,10.0000,-0.0052,-0.3366},
				{0.0200,8.6225,6.0760,7.5640,12.2000,9.9999,-0.0063,7.5640,12.2000,10.0000,0.0000,7.5640,12.2000,9.9999,-0.0063,-0.3339},
				{0.0200,8.8570,5.9952,7.8120,12.4000,9.9997,-0.0074,7.8120,12.4000,10.0000,0.0000,7.8120,12.4000,9.9997,-0.0074,-0.3297},
				{0.0200,9.0956,5.9143,8.0640,12.6000,9.9995,-0.0085,8.0640,12.6000,10.0000,0.0000,8.0640,12.6000,9.9995,-0.0085,-0.3237},
				{0.0200,9.3386,5.8338,8.3200,12.8000,9.9993,-0.0094,8.3200,12.8000,10.0000,0.0000,8.3200,12.8000,9.9993,-0.0094,-0.3160},
				{0.0200,9.5861,5.7541,8.5800,13.0000,9.9991,-0.0100,8.5800,13.0000,10.0000,0.0000,8.5800,13.0000,9.9991,-0.0100,-0.3065},
				{0.0200,9.8383,5.6759,8.8440,13.1999,9.9989,-0.0103,8.8440,13.2000,10.0000,0.0000,8.8440,13.1999,9.9989,-0.0103,-0.2952},
				{0.0200,10.0952,5.5995,9.1120,13.3999,9.9987,-0.0101,9.1120,13.4000,10.0000,0.0000,9.1120,13.3999,9.9987,-0.0101,-0.2822},
				{0.0200,10.3569,5.5257,9.3840,13.5999,9.9986,-0.0092,9.3840,13.6000,10.0000,0.0000,9.3840,13.5999,9.9986,-0.0092,-0.2674},
				{0.0200,10.6237,5.4549,9.6600,13.7998,9.9984,-0.0073,9.6600,13.8000,10.0000,0.0000,9.6600,13.7998,9.9984,-0.0073,-0.2509},
				{0.0200,10.8878,5.3897,9.9320,13.5998,-10.0009,-999.9641,9.9320,13.6000,-10.0000,0.0000,9.9320,13.5998,-10.0009,-999.9641,-0.2334},
				{0.0200,11.1490,5.3300,10.2000,13.3998,-10.0007,0.0109,10.2000,13.4000,-10.0000,0.0000,10.2000,13.3998,-10.0007,0.0109,-0.2152},
				{0.0200,11.4075,5.2761,10.4640,13.1998,-10.0004,0.0125,10.4640,13.2000,-10.0000,0.0000,10.4640,13.1998,-10.0004,0.0125,-0.1964},
				{0.0200,11.6629,5.2278,10.7240,12.9998,-10.0001,0.0133,10.7240,13.0000,-10.0000,0.0000,10.7240,12.9998,-10.0001,0.0133,-0.1773},
				{0.0200,11.9153,5.1850,10.9799,12.7998,-9.9999,0.0132,10.9800,12.8000,-10.0000,0.0000,10.9799,12.7998,-9.9999,0.0132,-0.1582},
				{0.0200,12.1646,5.1477,11.2319,12.5998,-9.9996,0.0124,11.2320,12.6000,-10.0000,0.0000,11.2319,12.5998,-9.9996,0.0124,-0.1393},
				{0.0200,12.4105,5.1156,11.4799,12.3998,-9.9994,0.0110,11.4800,12.4000,-10.0000,0.0000,11.4799,12.3998,-9.9994,0.0110,-0.1208},
				{0.0200,12.6529,5.0883,11.7239,12.1998,-9.9992,0.0090,11.7240,12.2000,-10.0000,0.0000,11.7239,12.1998,-9.9992,0.0090,-0.1031},
				{0.0200,12.8919,5.0656,11.9639,11.9999,-9.9991,0.0067,11.9640,12.0000,-10.0000,0.0000,11.9639,11.9999,-9.9991,0.0067,-0.0863},
				{0.0200,13.1271,5.0472,12.1999,11.7999,-9.9990,0.0042,12.2000,11.8000,-10.0000,0.0000,12.1999,11.7999,-9.9990,0.0042,-0.0705},
				{0.0200,13.3587,5.0325,12.4319,11.5999,-9.9990,0.0017,12.4320,11.6000,-10.0000,0.0000,12.4319,11.5999,-9.9990,0.0017,-0.0560},
				{0.0200,13.5864,5.0213,12.6599,11.3999,-9.9990,-0.0006,12.6600,11.4000,-10.0000,0.0000,12.6599,11.3999,-9.9990,-0.0006,-0.0429},
				{0.0200,13.8102,5.0130,12.8839,11.1999,-9.9990,-0.0027,12.8840,11.2000,-10.0000,0.0000,12.8839,11.1999,-9.9990,-0.0027,-0.0314},
				{0.0200,14.0302,5.0072,13.1039,11.0000,-9.9991,-0.0044,13.1040,11.0000,-10.0000,0.0000,13.1039,11.0000,-9.9991,-0.0044,-0.0215},
				{0.0200,14.2461,5.0035,13.3199,10.8000,-9.9992,-0.0059,13.3200,10.8000,-10.0000,0.0000,13.3199,10.8000,-9.9992,-0.0059,-0.0134},
				{0.0200,14.4581,5.0013,13.5319,10.6000,-9.9994,-0.0070,13.5320,10.6000,-10.0000,0.0000,13.5319,10.6000,-9.9994,-0.0070,-0.0071},
				{0.0200,14.6661,5.0003,13.7399,10.4000,-9.9995,-0.0078,13.7400,10.4000,-10.0000,0.0000,13.7399,10.4000,-9.9995,-0.0078,-0.0028},
				{0.0200,14.8701,5.0000,13.9439,10.2000,-9.9997,-0.0084,13.9440,10.2000,-10.0000,0.0000,13.9439,10.2000,-9.9997,-0.0084,-0.0004},
				{0.0200,15.0000,5.0000,14.0738,6.4946,-185.2714,-8763.5868,14.0739,10.0000,-10.0000,0.0000,14.0738,6.4946,-185.2714,-8763.5868,0.0000},
				{0.0200,15.2000,5.0004,14.2738,10.0000,175.2708,18027.1128,14.2739,10.0000,10.0000,0.0000,14.2738,10.0000,175.2708,18027.1128,0.0058},
				{0.0200,15.4000,5.0031,14.4738,9.9999,-0.0054,-8763.8107,14.4739,10.0000,10.0000,0.0000,14.4738,9.9999,-0.0054,-8763.8107,0.0230},
				{0.0200,15.5998,5.0103,14.6738,9.9997,-0.0111,-0.2866,14.6739,10.0000,10.0000,0.0000,14.6738,9.9997,-0.0111,-0.2866,0.0517},
				{0.0200,15.7993,5.0246,14.8738,9.9993,-0.0190,-0.3956,14.8739,10.0000,10.0000,0.0000,14.8738,9.9993,-0.0190,-0.3956,0.0935},
				{0.0200,15.9978,5.0487,15.0738,9.9986,-0.0313,-0.6150,15.0739,10.0000,10.0000,0.0000,15.0738,9.9986,-0.0313,-0.6150,0.1505},
				{0.0200,16.1943,5.0858,15.2737,9.9976,-0.0507,-0.9682,15.2739,10.0000,10.0000,0.0000,15.2737,9.9976,-0.0507,-0.9682,0.2259},
				{0.0200,16.3869,5.1396,15.4736,9.9961,-0.0790,-1.4148,15.4739,10.0000,10.0000,0.0000,15.4736,9.9961,-0.0790,-1.4148,0.3233},
				{0.0200,16.5723,5.2141,15.6735,9.9938,-0.1119,-1.6447,15.6739,10.0000,10.0000,0.0000,15.6735,9.9938,-0.1119,-1.6447,0.4451},
				{0.0200,16.7461,5.3127,15.8733,9.9912,-0.1283,-0.8186,15.8739,10.0000,10.0000,0.0000,15.8733,9.9912,-0.1283,-0.8186,0.5899},
				{0.0200,16.9029,5.4366,16.0731,9.9894,-0.0914,1.8432,16.0739,10.0000,10.0000,0.0000,16.0731,9.9894,-0.0914,1.8432,0.7490},
				{0.0200,17.0379,5.5838,16.2729,9.9895,0.0048,4.8095,16.2739,10.0000,10.0000,0.0000,16.2729,9.9895,0.0048,4.8095,0.9073},
				{0.0200,17.1491,5.7499,16.4727,9.9915,0.0975,4.6336,16.4739,10.0000,10.0000,0.0000,16.4727,9.9915,0.0975,4.6336,1.0503},
				{0.0200,17.2376,5.9291,16.6726,9.9940,0.1283,1.5441,16.6739,10.0000,10.0000,0.0000,16.6726,9.9940,0.1283,1.5441,1.1700},
				{0.0200,17.3064,6.1168,16.8726,9.9962,0.1088,-0.9744,16.8739,10.0000,10.0000,0.0000,16.8726,9.9962,0.1088,-0.9744,1.2654},
				{0.0200,17.3591,6.3097,17.0725,9.9977,0.0756,-1.6628,17.0739,10.0000,10.0000,0.0000,17.0725,9.9977,0.0756,-1.6628,1.3394},
				{0.0200,17.3992,6.5056,17.2725,9.9987,0.0479,-1.3831,17.2739,10.0000,10.0000,0.0000,17.2725,9.9987,0.0479,-1.3831,1.3957},
				{0.0200,17.4297,6.7033,17.4725,9.9993,0.0293,-0.9320,17.4739,10.0000,10.0000,0.0000,17.4725,9.9993,0.0293,-0.9320,1.4378},
				{0.0200,17.4530,6.9019,17.6725,9.9996,0.0176,-0.5828,17.6739,10.0000,10.0000,0.0000,17.6725,9.9996,0.0176,-0.5828,1.4681},
				{0.0200,17.4713,7.1010,17.8725,9.9998,0.0104,-0.3606,17.8739,10.0000,10.0000,0.0000,17.8725,9.9998,0.0104,-0.3606,1.4885},
				{0.0200,17.4864,7.3005,18.0725,9.9999,0.0058,-0.2306,18.0739,10.0000,10.0000,0.0000,18.0725,9.9999,0.0058,-0.2306,1.5004},
				{0.0200,17.5000,7.5000,18.2725,10.0000,0.0026,-0.1605,18.2739,10.0000,10.0000,0.0000,18.2725,10.0000,0.0026,-0.1605,1.5042},
				{0.0200,17.5136,7.6996,18.4725,10.0000,-0.0000,-0.1299,18.4739,10.0000,10.0000,0.0000,18.4725,10.0000,-0.0000,-0.1299,1.5004},
				{0.0200,17.5287,7.8990,18.6725,9.9999,-0.0026,-0.1299,18.6739,10.0000,10.0000,0.0000,18.6725,9.9999,-0.0026,-0.1299,1.4885},
				{0.0200,17.5470,8.0981,18.8724,9.9998,-0.0058,-0.1605,18.8739,10.0000,10.0000,0.0000,18.8724,9.9998,-0.0058,-0.1605,1.4681},
				{0.0200,17.5703,8.2968,19.0724,9.9996,-0.0104,-0.2306,19.0739,10.0000,10.0000,0.0000,19.0724,9.9996,-0.0104,-0.2306,1.4377},
				{0.0200,17.6008,8.4944,19.2724,9.9993,-0.0176,-0.3605,19.2739,10.0000,10.0000,0.0000,19.2724,9.9993,-0.0176,-0.3605,1.3957},
				{0.0200,17.6409,8.6903,19.4724,9.9987,-0.0293,-0.5829,19.4739,10.0000,10.0000,0.0000,19.4724,9.9987,-0.0293,-0.5829,1.3394},
				{0.0200,17.6936,8.8832,19.6724,9.9977,-0.0479,-0.9320,19.6739,10.0000,10.0000,0.0000,19.6724,9.9977,-0.0479,-0.9320,1.2654},
				{0.0200,17.7624,9.0709,19.8723,9.9962,-0.0756,-1.3832,19.8739,10.0000,10.0000,0.0000,19.8723,9.9962,-0.0756,-1.3832,1.1700},
				{0.0200,17.8509,9.2501,20.0722,9.9940,-0.1088,-1.6628,20.0739,10.0000,10.0000,0.0000,20.0722,9.9940,-0.1088,-1.6628,1.0503},
				{0.0200,17.9621,9.4162,20.2720,9.9915,-0.1283,-0.9743,20.2739,10.0000,10.0000,0.0000,20.2720,9.9915,-0.1283,-0.9743,0.9073},
				{0.0200,18.0971,9.5634,20.4718,9.9895,-0.0974,1.5445,20.4739,10.0000,10.0000,0.0000,20.4718,9.9895,-0.0974,1.5445,0.7489},
				{0.0200,18.2539,9.6873,20.6716,9.9894,-0.0048,4.6339,20.6739,10.0000,10.0000,0.0000,20.6716,9.9894,-0.0048,4.6339,0.5898},
				{0.0200,18.4277,9.7859,20.8714,9.9912,0.0914,4.8092,20.8739,10.0000,10.0000,0.0000,20.8714,9.9912,0.0914,4.8092,0.4451},
				{0.0200,18.6132,9.8604,21.0713,9.9938,0.1283,1.8428,21.0739,10.0000,10.0000,0.0000,21.0713,9.9938,0.1283,1.8428,0.3233},
				{0.0200,18.8057,9.9142,21.2712,9.9961,0.1119,-0.8188,21.2739,10.0000,10.0000,0.0000,21.2712,9.9961,0.1119,-0.8188,0.2259},
				{0.0200,19.0022,9.9513,21.4711,9.9976,0.0790,-1.6446,21.4739,10.0000,10.0000,0.0000,21.4711,9.9976,0.0790,-1.6446,0.1505},
				{0.0200,19.2007,9.9754,21.6711,9.9986,0.0507,-1.4149,21.6739,10.0000,10.0000,0.0000,21.6711,9.9986,0.0507,-1.4149,0.0935},
				{0.0200,19.4002,9.9897,21.8711,9.9993,0.0313,-0.9682,21.8739,10.0000,10.0000,0.0000,21.8711,9.9993,0.0313,-0.9682,0.0517},
				{0.0200,19.6000,9.9969,22.0711,9.9997,0.0190,-0.6149,22.0739,10.0000,10.0000,0.0000,22.0711,9.9997,0.0190,-0.6149,0.0230},
				{0.0200,19.8000,9.9996,22.2711,9.9999,0.0111,-0.3956,22.2739,10.0000,10.0000,0.0000,22.2711,9.9999,0.0111,-0.3956,0.0058},
				{0.0200,20.0000,10.0000,22.4711,10.0000,0.0054,-0.2865,22.4739,10.0000,10.0000,0.0000,22.4711,10.0000,0.0054,-0.2865,-0.0000},
				{0.0200,20.2000,9.9996,22.6711,10.0000,-0.0000,-0.2702,22.6739,10.0000,10.0000,0.0000,22.6711,10.0000,-0.0000,-0.2702,-0.0058},
				{0.0200,20.4000,9.9969,22.8711,9.9999,-0.0054,-0.2702,22.8739,10.0000,10.0000,0.0000,22.8711,9.9999,-0.0054,-0.2702,-0.0230},
				{0.0200,20.5999,9.9897,23.0711,9.9997,-0.0111,-0.2865,23.0739,10.0000,10.0000,0.0000,23.0711,9.9997,-0.0111,-0.2865,-0.0517},
				{0.0200,20.7993,9.9754,23.2711,9.9993,-0.0190,-0.3956,23.2739,10.0000,10.0000,0.0000,23.2711,9.9993,-0.0190,-0.3956,-0.0935},
				{0.0200,20.9979,9.9513,23.4710,9.9986,-0.0313,-0.6150,23.4739,10.0000,10.0000,0.0000,23.4710,9.9986,-0.0313,-0.6150,-0.1505},
				{0.0200,21.1943,9.9142,23.6710,9.9976,-0.0507,-0.9683,23.6739,10.0000,10.0000,0.0000,23.6710,9.9976,-0.0507,-0.9683,-0.2259},
				{0.0200,21.3869,9.8604,23.8709,9.9961,-0.0790,-1.4149,23.8739,10.0000,10.0000,0.0000,23.8709,9.9961,-0.0790,-1.4149,-0.3233},
				{0.0200,21.5723,9.7859,24.0708,9.9938,-0.1119,-1.6446,24.0739,10.0000,10.0000,0.0000,24.0708,9.9938,-0.1119,-1.6446,-0.4451},
				{0.0200,21.7462,9.6873,24.2706,9.9912,-0.1283,-0.8184,24.2739,10.0000,10.0000,0.0000,24.2706,9.9912,-0.1283,-0.8184,-0.5899},
				{0.0200,21.9029,9.5634,24.4704,9.9894,-0.0914,1.8435,24.4739,10.0000,10.0000,0.0000,24.4704,9.9894,-0.0914,1.8435,-0.7490},
				{0.0200,22.0379,9.4161,24.6702,9.9895,0.0048,4.8097,24.6739,10.0000,10.0000,0.0000,24.6702,9.9895,0.0048,4.8097,-0.9074},
				{0.0200,22.1491,9.2501,24.8700,9.9915,0.0975,4.6333,24.8739,10.0000,10.0000,0.0000,24.8700,9.9915,0.0975,4.6333,-1.0503},
				{0.0200,22.2376,9.0709,25.0699,9.9940,0.1283,1.5437,25.0739,10.0000,10.0000,0.0000,25.0699,9.9940,0.1283,1.5437,-1.1700},
				{0.0200,22.3064,8.8832,25.2698,9.9962,0.1088,-0.9746,25.2739,10.0000,10.0000,0.0000,25.2698,9.9962,0.1088,-0.9746,-1.2654},
				{0.0200,22.3591,8.6903,25.4698,9.9977,0.0756,-1.6628,25.4739,10.0000,10.0000,0.0000,25.4698,9.9977,0.0756,-1.6628,-1.3394},
				{0.0200,22.3992,8.4944,25.6698,9.9987,0.0479,-1.3831,25.6739,10.0000,10.0000,0.0000,25.6698,9.9987,0.0479,-1.3831,-1.3957},
				{0.0200,22.4297,8.2967,25.8697,9.9993,0.0293,-0.9319,25.8739,10.0000,10.0000,0.0000,25.8697,9.9993,0.0293,-0.9319,-1.4378},
				{0.0200,22.4530,8.0981,26.0697,9.9996,0.0176,-0.5828,26.0739,10.0000,10.0000,0.0000,26.0697,9.9996,0.0176,-0.5828,-1.4681},
				{0.0200,22.4713,7.8989,26.2697,9.9998,0.0104,-0.3605,26.2739,10.0000,10.0000,0.0000,26.2697,9.9998,0.0104,-0.3605,-1.4885},
				{0.0200,22.4864,7.6995,26.4697,9.9999,0.0058,-0.2306,26.4739,10.0000,10.0000,0.0000,26.4697,9.9999,0.0058,-0.2306,-1.5004},
				{0.0200,22.5000,7.5000,26.6697,10.0000,0.0026,-0.1604,26.6739,10.0000,10.0000,0.0000,26.6697,10.0000,0.0026,-0.1604,-1.5042},
				{0.0200,22.5136,7.3004,26.8697,10.0000,-0.0000,-0.1299,26.8739,10.0000,10.0000,0.0000,26.8697,10.0000,-0.0000,-0.1299,-1.5004},
				{0.0200,22.5287,7.1010,27.0697,9.9999,-0.0026,-0.1299,27.0739,10.0000,10.0000,0.0000,27.0697,9.9999,-0.0026,-0.1299,-1.4885},
				{0.0200,22.5470,6.9018,27.2697,9.9998,-0.0058,-0.1604,27.2739,10.0000,10.0000,0.0000,27.2697,9.9998,-0.0058,-0.1604,-1.4681},
				{0.0200,22.5703,6.7032,27.4697,9.9996,-0.0104,-0.2306,27.4739,10.0000,10.0000,0.0000,27.4697,9.9996,-0.0104,-0.2306,-1.4377},
				{0.0200,22.6008,6.5056,27.6697,9.9993,-0.0176,-0.3606,27.6739,10.0000,10.0000,0.0000,27.6697,9.9993,-0.0176,-0.3606,-1.3957},
				{0.0200,22.6409,6.3097,27.8697,9.9987,-0.0293,-0.5829,27.8739,10.0000,10.0000,0.0000,27.8697,9.9987,-0.0293,-0.5829,-1.3394},
				{0.0200,22.6937,6.1168,28.0696,9.9977,-0.0479,-0.9320,28.0739,10.0000,10.0000,0.0000,28.0696,9.9977,-0.0479,-0.9320,-1.2654},
				{0.0200,22.7624,5.9291,28.2696,9.9962,-0.0756,-1.3832,28.2739,10.0000,10.0000,0.0000,28.2696,9.9962,-0.0756,-1.3832,-1.1700},
				{0.0200,22.8509,5.7498,28.4694,9.9940,-0.1089,-1.6628,28.4739,10.0000,10.0000,0.0000,28.4694,9.9940,-0.1089,-1.6628,-1.0503},
				{0.0200,22.9621,5.5838,28.6693,9.9915,-0.1283,-0.9741,28.6739,10.0000,10.0000,0.0000,28.6693,9.9915,-0.1283,-0.9741,-0.9073},
				{0.0200,23.0971,5.4365,28.8691,9.9895,-0.0974,1.5449,28.8739,10.0000,10.0000,0.0000,28.8691,9.9895,-0.0974,1.5449,-0.7489},
				{0.0200,23.2539,5.3127,29.0688,9.9894,-0.0048,4.6341,29.0739,10.0000,10.0000,0.0000,29.0688,9.9894,-0.0048,4.6341,-0.5898},
				{0.0200,23.4277,5.2141,29.2687,9.9912,0.0914,4.8091,29.2739,10.0000,10.0000,0.0000,29.2687,9.9912,0.0914,4.8091,-0.4450},
				{0.0200,23.6132,5.1396,29.4685,9.9938,0.1283,1.8423,29.4739,10.0000,10.0000,0.0000,29.4685,9.9938,0.1283,1.8423,-0.3233},
				{0.0200,23.8057,5.0858,29.6685,9.9961,0.1119,-0.8190,29.6739,10.0000,10.0000,0.0000,29.6685,9.9961,0.1119,-0.8190,-0.2259},
				{0.0200,24.0022,5.0487,29.8684,9.9976,0.0790,-1.6446,29.8739,10.0000,10.0000,0.0000,29.8684,9.9976,0.0790,-1.6446,-0.1505},
				{0.0200,24.2007,5.0246,30.0684,9.9986,0.0507,-1.4148,30.0739,10.0000,10.0000,0.0000,30.0684,9.9986,0.0507,-1.4148,-0.0935},
				{0.0200,24.4002,5.0103,30.2684,9.9993,0.0313,-0.9682,30.2739,10.0000,10.0000,0.0000,30.2684,9.9993,0.0313,-0.9682,-0.0517},
				{0.0200,24.6001,5.0031,30.4684,9.9997,0.0190,-0.6149,30.4739,10.0000,10.0000,0.0000,30.4684,9.9997,0.0190,-0.6149,-0.0229},
				{0.0200,24.8000,5.0004,30.6684,9.9999,0.0111,-0.3956,30.6739,10.0000,10.0000,0.0000,30.6684,9.9999,0.0111,-0.3956,-0.0058},
				{0.0200,25.0000,5.0000,30.8684,10.0000,0.0054,-0.2865,30.8739,10.0000,10.0000,0.0000,30.8684,10.0000,0.0054,-0.2865,0.0000},
				{0.0200,25.2040,5.0008,31.0724,10.1999,9.9978,499.6211,31.0779,10.2000,10.0000,0.0000,31.0724,10.1999,9.9978,499.6211,0.0113},
				{0.0200,25.4120,5.0062,31.2804,10.3995,9.9786,-0.9628,31.2859,10.4000,10.0000,0.0000,31.2804,10.3995,9.9786,-0.9628,0.0447},
				{0.0200,25.6234,5.0212,31.4923,10.5986,9.9553,-1.1640,31.4979,10.6000,10.0000,0.0000,31.4923,10.5986,9.9553,-1.1640,0.1006},
				{0.0200,25.8373,5.0510,31.7083,10.7972,9.9269,-1.4207,31.7139,10.8000,10.0000,0.0000,31.7083,10.7972,9.9269,-1.4207,0.1800},
				{0.0200,26.0437,5.0989,31.9202,10.5957,-10.0745,-1000.0678,31.9259,10.6000,-10.0000,0.0000,31.9202,10.5957,-10.0745,-1000.0678,0.2790},
				{0.0200,26.2401,5.1672,32.1281,10.3944,-10.0624,0.6030,32.1339,10.4000,-10.0000,0.0000,32.1281,10.3944,-10.0624,0.6030,0.3923},
				{0.0200,26.4235,5.2562,32.3320,10.1939,-10.0243,1.9073,32.3379,10.2000,-10.0000,0.0000,32.3320,10.1939,-10.0243,1.9073,0.5117},
				{0.0200,26.5918,5.3640,32.5318,9.9944,-9.9747,2.4808,32.5379,10.0000,-10.0000,0.0000,32.5318,9.9944,-9.9747,2.4808,0.6271},
				{0.0200,26.7442,5.4872,32.7278,9.7956,-9.9402,1.7250,32.7339,9.8000,-10.0000,0.0000,32.7278,9.7956,-9.9402,1.7250,0.7303},
				{0.0200,26.8813,5.6215,32.9197,9.5970,-9.9326,0.3786,32.9259,9.6000,-10.0000,0.0000,32.9197,9.5970,-9.9326,0.3786,0.8171},
				{0.0200,27.0049,5.7631,33.1077,9.3981,-9.9434,-0.5420,33.1139,9.4000,-10.0000,0.0000,33.1077,9.3981,-9.9434,-0.5420,0.8864},
				{0.0200,27.1172,5.9088,33.2916,9.1989,-9.9597,-0.8120,33.2979,9.2000,-10.0000,0.0000,33.2916,9.1989,-9.9597,-0.8120,0.9394},
				{0.0200,27.2205,6.0562,33.4716,8.9994,-9.9740,-0.7165,33.4779,9.0000,-10.0000,0.0000,33.4716,8.9994,-9.9740,-0.7165,0.9780},
				{0.0200,27.3168,6.2035,33.6476,8.7998,-9.9845,-0.5253,33.6539,8.8000,-10.0000,0.0000,33.6476,8.7998,-9.9845,-0.5253,1.0039},
				{0.0200,27.4079,6.3494,33.8196,8.5999,-9.9917,-0.3578,33.8259,8.6000,-10.0000,0.0000,33.8196,8.5999,-9.9917,-0.3578,1.0188},
				{0.0200,27.4956,6.4927,33.9876,8.4000,-9.9965,-0.2406,33.9939,8.4000,-10.0000,0.0000,33.9876,8.4000,-9.9965,-0.2406,1.0239},
				{0.0200,27.5810,6.6327,34.1516,8.2000,-9.9998,-0.1671,34.1579,8.2000,-10.0000,0.0000,34.1516,8.2000,-9.9998,-0.1671,1.0199},
				{0.0200,27.6655,6.7686,34.3116,7.9999,-10.0023,-0.1243,34.3179,8.0000,-10.0000,0.0000,34.3116,7.9999,-10.0023,-0.1243,1.0075},
				{0.0200,27.7501,6.8997,34.4676,7.7999,-10.0043,-0.1008,34.4739,7.8000,-10.0000,0.0000,34.4676,7.7999,-10.0043,-0.1008,0.9869},
				{0.0200,27.8356,7.0253,34.6196,7.5997,-10.0061,-0.0879,34.6259,7.6000,-10.0000,0.0000,34.6196,7.5997,-10.0061,-0.0879,0.9583},
				{0.0200,27.9228,7.1449,34.7676,7.3996,-10.0076,-0.0780,34.7739,7.4000,-10.0000,0.0000,34.7676,7.3996,-10.0076,-0.0780,0.9218},
				{0.0200,28.0122,7.2577,34.9116,7.1994,-10.0089,-0.0636,34.9179,7.2000,-10.0000,0.0000,34.9116,7.1994,-10.0089,-0.0636,0.8775},
				{0.0200,28.1044,7.3631,35.0516,6.9992,-10.0097,-0.0376,35.0579,7.0000,-10.0000,0.0000,35.0516,6.9992,-10.0097,-0.0376,0.8256},
				{0.0200,28.1994,7.4604,35.1876,6.7990,-10.0095,0.0058,35.1939,6.8000,-10.0000,0.0000,35.1876,6.7990,-10.0095,0.0058,0.7670},
				{0.0200,28.2973,7.5489,35.3195,6.5989,-10.0082,0.0662,35.3259,6.6000,-10.0000,0.0000,35.3195,6.5989,-10.0082,0.0662,0.7027},
				{0.0200,28.3977,7.6283,35.4475,6.3988,-10.0055,0.1336,35.4539,6.4000,-10.0000,0.0000,35.4475,6.3988,-10.0055,0.1336,0.6343},
				{0.0200,28.5000,7.6982,35.5715,6.1987,-10.0018,0.1871,35.5779,6.2000,-10.0000,0.0000,35.5715,6.1987,-10.0018,0.1871,0.5638},
				{0.0200,28.6036,7.7587,35.6915,5.9988,-9.9977,0.2049,35.6979,6.0000,-10.0000,0.0000,35.6915,5.9988,-9.9977,0.2049,0.4934},
				{0.0200,28.7076,7.8101,35.8074,5.7989,-9.9942,0.1773,35.8139,5.8000,-10.0000,0.0000,35.8074,5.7989,-9.9942,0.1773,0.4253},
				{0.0200,28.8110,7.8530,35.9194,5.5990,-9.9918,0.1155,35.9259,5.6000,-10.0000,0.0000,35.9194,5.5990,-9.9918,0.1155,0.3612},
				{0.0200,28.9131,7.8882,36.0274,5.3992,-9.9910,0.0435,36.0339,5.4000,-10.0000,0.0000,36.0274,5.3992,-9.9910,0.0435,0.3024},
				{0.0200,29.0132,7.9165,36.1314,5.1994,-9.9913,-0.0164,36.1379,5.2000,-10.0000,0.0000,36.1314,5.1994,-9.9913,-0.0164,0.2495},
				{0.0200,29.1107,7.9389,36.2314,4.9995,-9.9924,-0.0536,36.2379,5.0000,-10.0000,0.0000,36.2314,4.9995,-9.9924,-0.0536,0.2029},
				{0.0200,29.2051,7.9563,36.3274,4.7997,-9.9938,-0.0689,36.3339,4.8000,-10.0000,0.0000,36.3274,4.7997,-9.9938,-0.0689,0.1624},
				{0.0200,29.2961,7.9695,36.4194,4.5998,-9.9951,-0.0689,36.4259,4.6000,-10.0000,0.0000,36.4194,4.5998,-9.9951,-0.0689,0.1277},
				{0.0200,29.3835,7.9794,36.5074,4.3998,-9.9964,-0.0608,36.5139,4.4000,-10.0000,0.0000,36.5074,4.3998,-9.9964,-0.0608,0.0984},
				{0.0200,29.4672,7.9867,36.5914,4.1999,-9.9974,-0.0498,36.5979,4.2000,-10.0000,0.0000,36.5914,4.1999,-9.9974,-0.0498,0.0739},
				{0.0200,29.5471,7.9917,36.6714,3.9999,-9.9981,-0.0388,36.6779,4.0000,-10.0000,0.0000,36.6714,3.9999,-9.9981,-0.0388,0.0538},
				{0.0200,29.6230,7.9952,36.7474,3.8000,-9.9987,-0.0292,36.7539,3.8000,-10.0000,0.0000,36.7474,3.8000,-9.9987,-0.0292,0.0376},
				{0.0200,29.6949,7.9974,36.8194,3.6000,-9.9991,-0.0214,36.8259,3.6000,-10.0000,0.0000,36.8194,3.6000,-9.9991,-0.0214,0.0249},
				{0.0200,29.7629,7.9988,36.8874,3.4000,-9.9994,-0.0154,36.8939,3.4000,-10.0000,0.0000,36.8874,3.4000,-9.9994,-0.0154,0.0152},
				{0.0200,29.8269,7.9995,36.9514,3.2000,-9.9997,-0.0108,36.9579,3.2000,-10.0000,0.0000,36.9514,3.2000,-9.9997,-0.0108,0.0082},
				{0.0200,29.8869,7.9999,37.0114,3.0000,-9.9998,-0.0073,37.0179,3.0000,-10.0000,0.0000,37.0114,3.0000,-9.9998,-0.0073,0.0036},
				{0.0200,29.9429,8.0000,37.0674,2.8000,-9.9999,-0.0048,37.0739,2.8000,-10.0000,0.0000,37.0674,2.8000,-9.9999,-0.0048,0.0009},
				{0.0200,29.9949,8.0000,37.1194,2.6000,-10.0000,-0.0030,37.1259,2.6000,-10.0000,0.0000,37.1194,2.6000,-10.0000,-0.0030,0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.2540,-117.2977,-5364.8862,37.1310,2.4000,-10.0000,0.0000,37.1244,0.2540,-117.2977,-5364.8862,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,-12.7023,5229.7690,37.1310,2.2000,-10.0000,0.0000,37.1244,0.0000,-12.7023,5229.7690,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,635.1154,37.1310,2.0000,-10.0000,0.0000,37.1244,0.0000,0.0000,635.1154,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,1.8000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,1.6000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,1.4000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,1.2000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,1.0000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,0.8000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,0.6000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,0.4000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,0.2000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,0.0000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,30.0000,8.0000,37.1244,0.0000,0.0000,0.0000,37.1310,-0.2000,-10.0000,0.0000,37.1244,0.0000,0.0000,0.0000,-0.0000},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}