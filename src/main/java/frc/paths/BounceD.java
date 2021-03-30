package frc.paths;

import com.team319.trajectory.Path;

public class BounceD extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,22.5000,12.4960,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,-1.5708},
				{0.0200,22.5000,12.4880,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,-1.5708},
				{0.0200,22.5000,12.4760,0.0240,0.6000,10.0000,-0.0000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,-0.0000,-1.5707},
				{0.0200,22.5000,12.4600,0.0400,0.8000,10.0000,-0.0000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,-0.0000,-1.5707},
				{0.0200,22.5000,12.4400,0.0600,1.0000,10.0000,-0.0000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,-0.0000,-1.5705},
				{0.0200,22.5000,12.4160,0.0840,1.2000,10.0000,-0.0000,0.0840,1.2000,10.0000,0.0000,0.0840,1.2000,10.0000,-0.0000,-1.5702},
				{0.0200,22.5000,12.3880,0.1120,1.4000,10.0000,-0.0000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,-0.0000,-1.5698},
				{0.0200,22.5001,12.3560,0.1440,1.6000,10.0000,-0.0000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,-0.0000,-1.5691},
				{0.0200,22.5002,12.3200,0.1800,1.8000,10.0000,-0.0000,0.1800,1.8000,10.0000,0.0000,0.1800,1.8000,10.0000,-0.0000,-1.5681},
				{0.0200,22.5003,12.2800,0.2200,2.0000,10.0000,-0.0001,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,-0.0001,-1.5668},
				{0.0200,22.5005,12.2360,0.2640,2.2000,10.0000,-0.0001,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,-0.0001,-1.5651},
				{0.0200,22.5008,12.1880,0.3120,2.4000,10.0000,-0.0002,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,-0.0002,-1.5629},
				{0.0200,22.5013,12.1360,0.3640,2.6000,10.0000,-0.0003,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,-0.0003,-1.5602},
				{0.0200,22.5020,12.0800,0.4200,2.8000,10.0000,-0.0005,0.4200,2.8000,10.0000,0.0000,0.4200,2.8000,10.0000,-0.0005,-1.5567},
				{0.0200,22.5030,12.0200,0.4800,3.0000,10.0000,-0.0007,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,-0.0007,-1.5525},
				{0.0200,22.5043,11.9560,0.5440,3.2000,9.9999,-0.0010,0.5440,3.2000,10.0000,0.0000,0.5440,3.2000,9.9999,-0.0010,-1.5475},
				{0.0200,22.5061,11.8881,0.6120,3.4000,9.9999,-0.0013,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,9.9999,-0.0013,-1.5415},
				{0.0200,22.5084,11.8161,0.6840,3.6000,9.9999,-0.0017,0.6840,3.6000,10.0000,0.0000,0.6840,3.6000,9.9999,-0.0017,-1.5344},
				{0.0200,22.5115,11.7402,0.7600,3.8000,9.9998,-0.0023,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,9.9998,-0.0023,-1.5261},
				{0.0200,22.5155,11.6603,0.8400,4.0000,9.9998,-0.0030,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,9.9998,-0.0030,-1.5165},
				{0.0200,22.5205,11.5764,0.9240,4.2000,9.9997,-0.0039,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,9.9997,-0.0039,-1.5055},
				{0.0200,22.5268,11.4886,1.0120,4.4000,9.9996,-0.0050,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,9.9996,-0.0050,-1.4928},
				{0.0200,22.5346,11.3970,1.1040,4.6000,9.9995,-0.0063,1.1040,4.6000,10.0000,0.0000,1.1040,4.6000,9.9995,-0.0063,-1.4783},
				{0.0200,22.5442,11.3014,1.2000,4.7999,9.9993,-0.0079,1.2000,4.8000,10.0000,0.0000,1.2000,4.7999,9.9993,-0.0079,-1.4619},
				{0.0200,22.5560,11.2021,1.3000,4.9999,9.9991,-0.0097,1.3000,5.0000,10.0000,0.0000,1.3000,4.9999,9.9991,-0.0097,-1.4434},
				{0.0200,22.5703,11.0991,1.4040,5.1999,9.9989,-0.0118,1.4040,5.2000,10.0000,0.0000,1.4040,5.1999,9.9989,-0.0118,-1.4226},
				{0.0200,22.5875,10.9925,1.5120,5.3999,9.9986,-0.0142,1.5120,5.4000,10.0000,0.0000,1.5120,5.3999,9.9986,-0.0142,-1.3993},
				{0.0200,22.6080,10.8824,1.6240,5.5998,9.9983,-0.0166,1.6240,5.6000,10.0000,0.0000,1.6240,5.5998,9.9983,-0.0166,-1.3734},
				{0.0200,22.6323,10.7690,1.7400,5.7998,9.9979,-0.0188,1.7400,5.8000,10.0000,0.0000,1.7400,5.7998,9.9979,-0.0188,-1.3447},
				{0.0200,22.6611,10.6525,1.8600,5.9998,9.9975,-0.0205,1.8600,6.0000,10.0000,0.0000,1.8600,5.9998,9.9975,-0.0205,-1.3132},
				{0.0200,22.6947,10.5331,1.9840,6.1997,9.9971,-0.0210,1.9840,6.2000,10.0000,0.0000,1.9840,6.1997,9.9971,-0.0210,-1.2786},
				{0.0200,22.7338,10.4113,2.1120,6.3996,9.9967,-0.0195,2.1120,6.4000,10.0000,0.0000,2.1120,6.3996,9.9967,-0.0195,-1.2412},
				{0.0200,22.7790,10.2873,2.2440,6.5996,9.9964,-0.0153,2.2440,6.6000,10.0000,0.0000,2.2440,6.5996,9.9964,-0.0153,-1.2009},
				{0.0200,22.8309,10.1616,2.3799,6.7995,9.9962,-0.0076,2.3800,6.8000,10.0000,0.0000,2.3799,6.7995,9.9962,-0.0076,-1.1579},
				{0.0200,22.8900,10.0346,2.5199,6.9994,9.9963,0.0036,2.5200,7.0000,10.0000,0.0000,2.5199,6.9994,9.9963,0.0036,-1.1127},
				{0.0200,22.9567,9.9070,2.6639,7.1993,9.9966,0.0179,2.6640,7.2000,10.0000,0.0000,2.6639,7.1993,9.9966,0.0179,-1.0656},
				{0.0200,23.0314,9.7793,2.8119,7.3993,9.9973,0.0336,2.8120,7.4000,10.0000,0.0000,2.8119,7.3993,9.9973,0.0336,-1.0174},
				{0.0200,23.1144,9.6520,2.9639,7.5992,9.9983,0.0480,2.9640,7.6000,10.0000,0.0000,2.9639,7.5992,9.9983,0.0480,-0.9686},
				{0.0200,23.2059,9.5257,3.1199,7.7992,9.9994,0.0583,3.1200,7.8000,10.0000,0.0000,3.1199,7.7992,9.9994,0.0583,-0.9202},
				{0.0200,23.3058,9.4007,3.2799,7.9992,10.0007,0.0622,3.2800,8.0000,10.0000,0.0000,3.2799,7.9992,10.0007,0.0622,-0.8727},
				{0.0200,23.4141,9.2775,3.4438,8.1993,10.0019,0.0589,3.4440,8.2000,10.0000,0.0000,3.4438,8.1993,10.0019,0.0589,-0.8271},
				{0.0200,23.5305,9.1564,3.6118,8.3993,10.0029,0.0493,3.6120,8.4000,10.0000,0.0000,3.6118,8.3993,10.0029,0.0493,-0.7838},
				{0.0200,23.6548,9.0376,3.7838,8.5994,10.0036,0.0356,3.7840,8.6000,10.0000,0.0000,3.7838,8.5994,10.0036,0.0356,-0.7434},
				{0.0200,23.7866,8.9209,3.9598,8.7995,10.0040,0.0204,3.9600,8.8000,10.0000,0.0000,3.9598,8.7995,10.0040,0.0204,-0.7063},
				{0.0200,23.9255,8.8065,4.1398,8.9996,10.0041,0.0062,4.1400,9.0000,10.0000,0.0000,4.1398,8.9996,10.0041,0.0062,-0.6727},
				{0.0200,24.0711,8.6940,4.3238,9.1997,10.0040,-0.0056,4.3240,9.2000,10.0000,0.0000,4.3238,9.1997,10.0040,-0.0056,-0.6428},
				{0.0200,24.2231,8.5834,4.5118,9.3997,10.0037,-0.0145,4.5120,9.4000,10.0000,0.0000,4.5118,9.3997,10.0037,-0.0145,-0.6165},
				{0.0200,24.3810,8.4742,4.7038,9.5998,10.0033,-0.0203,4.7040,9.6000,10.0000,0.0000,4.7038,9.5998,10.0033,-0.0203,-0.5940},
				{0.0200,24.5445,8.3661,4.8998,9.7999,10.0028,-0.0236,4.9000,9.8000,10.0000,0.0000,4.8998,9.7999,10.0028,-0.0236,-0.5749},
				{0.0200,24.7133,8.2587,5.0998,9.9999,10.0023,-0.0250,5.1000,10.0000,10.0000,0.0000,5.0998,9.9999,10.0023,-0.0250,-0.5594},
				{0.0200,24.8869,8.1516,5.3038,10.1999,10.0018,-0.0248,5.3040,10.2000,10.0000,0.0000,5.3038,10.1999,10.0018,-0.0248,-0.5470},
				{0.0200,25.0650,8.0443,5.5118,10.4000,10.0013,-0.0235,5.5120,10.4000,10.0000,0.0000,5.5118,10.4000,10.0013,-0.0235,-0.5377},
				{0.0200,25.2475,7.9364,5.7238,10.6000,10.0009,-0.0213,5.7240,10.6000,10.0000,0.0000,5.7238,10.6000,10.0009,-0.0213,-0.5311},
				{0.0200,25.4340,7.8274,5.9398,10.8000,10.0006,-0.0181,5.9400,10.8000,10.0000,0.0000,5.9398,10.8000,10.0006,-0.0181,-0.5268},
				{0.0200,25.6243,7.7170,6.1598,11.0000,10.0003,-0.0140,6.1600,11.0000,10.0000,0.0000,6.1598,11.0000,10.0003,-0.0140,-0.5246},
				{0.0200,25.8183,7.6049,6.3838,11.2000,10.0001,-0.0091,6.3840,11.2000,10.0000,0.0000,6.3838,11.2000,10.0001,-0.0091,-0.5237},
				{0.0200,26.0157,7.4909,6.6118,11.4000,10.0000,-0.0042,6.6120,11.4000,10.0000,0.0000,6.6118,11.4000,10.0000,-0.0042,-0.5235},
				{0.0200,26.2176,7.3766,6.8438,11.5998,9.9876,-0.6206,6.8440,11.6000,10.0000,0.0000,6.8438,11.5998,9.9876,-0.6206,-0.5015},
				{0.0200,26.4272,7.2683,7.0797,11.7985,9.9398,-2.3902,7.0800,11.8000,10.0000,0.0000,7.0797,11.7985,9.9398,-2.3902,-0.4474},
				{0.0200,26.6473,7.1727,7.3197,11.9969,9.9186,-1.0624,7.3200,12.0000,10.0000,0.0000,7.3197,11.9969,9.9186,-1.0624,-0.3691},
				{0.0200,26.8786,7.0952,7.5636,12.1956,9.9355,0.8482,7.5640,12.2000,10.0000,0.0000,7.5636,12.1956,9.9355,0.8482,-0.2766},
				{0.0200,27.1200,7.0389,7.8115,12.3954,9.9886,2.6525,7.8120,12.4000,10.0000,0.0000,7.8115,12.3954,9.9886,2.6525,-0.1825},
				{0.0200,27.3695,7.0039,8.0634,12.5963,10.0469,2.9145,8.0640,12.6000,10.0000,0.0000,8.0634,12.5963,10.0469,2.9145,-0.0991},
				{0.0200,27.6249,6.9872,8.3194,12.7978,10.0741,1.3620,8.3200,12.8000,10.0000,0.0000,8.3194,12.7978,10.0741,1.3620,-0.0353},
				{0.0200,27.8849,6.9838,8.5794,12.9991,10.0643,-0.4884,8.5800,13.0000,10.0000,0.0000,8.5794,12.9991,10.0643,-0.4884,0.0052},
				{0.0200,28.1408,6.9879,8.8354,12.7998,-9.9636,-1001.3970,8.8360,12.8000,-10.0000,0.0000,8.8354,12.7998,-9.9636,-1001.3970,0.0227},
				{0.0200,28.3928,6.9939,9.0874,12.6000,-9.9918,-1.4105,9.0880,12.6000,-10.0000,0.0000,9.0874,12.6000,-9.9918,-1.4105,0.0226},
				{0.0200,28.6407,6.9983,9.3354,12.3999,-10.0027,-0.5445,9.3360,12.4000,-10.0000,0.0000,9.3354,12.3999,-10.0027,-0.5445,0.0123},
				{0.0200,28.8847,6.9999,9.5794,12.1999,-10.0002,0.1277,9.5800,12.2000,-10.0000,0.0000,9.5794,12.1999,-10.0002,0.1277,0.0018},
				{0.0200,29.0000,7.0000,9.6947,5.7645,-321.7735,-15588.6655,9.6953,12.0000,-10.0000,0.0000,9.6947,5.7645,-321.7735,-15588.6655,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,-288.2236,1677.4944,9.6953,11.8000,-10.0000,0.0000,9.6947,0.0000,-288.2236,1677.4944,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,14411.1789,9.6953,11.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,14411.1789,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,11.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,11.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,11.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,10.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,10.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,10.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,10.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,10.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,9.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,9.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,9.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,9.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,9.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,8.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,8.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,8.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,8.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,8.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,7.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,7.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,7.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,7.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,7.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,6.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,6.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,6.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,6.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,6.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,5.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,5.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,5.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,5.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,5.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,4.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,4.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,4.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,4.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,4.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,3.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,3.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,3.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,3.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,3.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,2.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,2.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,2.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,2.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,2.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,1.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,1.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,1.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,1.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,1.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,0.8000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,0.6000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,0.4000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,0.2000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},
				{0.0200,29.0000,7.0000,9.6947,0.0000,0.0000,0.0000,9.6953,-0.0000,-10.0000,0.0000,9.6947,0.0000,0.0000,0.0000,-0.0000},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}