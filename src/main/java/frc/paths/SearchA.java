package frc.paths;

import com.team319.trajectory.Path;

public class SearchA extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,1.2540,7.5000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,-0.0000},
				{0.0200,1.2620,7.5000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,-0.0000},
				{0.0200,1.2740,7.5000,0.0240,0.6000,10.0000,-0.0000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,-0.0000,-0.0000},
				{0.0200,1.2900,7.5000,0.0400,0.8000,10.0000,-0.0000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,-0.0000,-0.0001},
				{0.0200,1.3100,7.5000,0.0600,1.0000,10.0000,-0.0000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,-0.0000,-0.0002},
				{0.0200,1.3340,7.5000,0.0840,1.2000,10.0000,-0.0000,0.0840,1.2000,10.0000,0.0000,0.0840,1.2000,10.0000,-0.0000,-0.0004},
				{0.0200,1.3620,7.5000,0.1120,1.4000,10.0000,-0.0000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,-0.0000,-0.0006},
				{0.0200,1.3940,7.5000,0.1440,1.6000,10.0000,-0.0000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,-0.0000,-0.0010},
				{0.0200,1.4300,7.4999,0.1800,1.8000,10.0000,-0.0000,0.1800,1.8000,10.0000,0.0000,0.1800,1.8000,10.0000,-0.0000,-0.0016},
				{0.0200,1.4700,7.4998,0.2200,2.0000,10.0000,-0.0000,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,-0.0000,-0.0024},
				{0.0200,1.5140,7.4997,0.2640,2.2000,10.0000,-0.0001,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,-0.0001,-0.0034},
				{0.0200,1.5620,7.4995,0.3120,2.4000,10.0000,-0.0001,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,-0.0001,-0.0047},
				{0.0200,1.6140,7.4992,0.3640,2.6000,10.0000,-0.0001,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,-0.0001,-0.0063},
				{0.0200,1.6700,7.4988,0.4200,2.8000,10.0000,-0.0002,0.4200,2.8000,10.0000,0.0000,0.4200,2.8000,10.0000,-0.0002,-0.0084},
				{0.0200,1.7300,7.4982,0.4800,3.0000,10.0000,-0.0002,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,-0.0002,-0.0109},
				{0.0200,1.7940,7.4974,0.5440,3.2000,10.0000,-0.0003,0.5440,3.2000,10.0000,0.0000,0.5440,3.2000,10.0000,-0.0003,-0.0138},
				{0.0200,1.8620,7.4964,0.6120,3.4000,10.0000,-0.0004,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,10.0000,-0.0004,-0.0174},
				{0.0200,1.9340,7.4950,0.6840,3.6000,10.0000,-0.0006,0.6840,3.6000,10.0000,0.0000,0.6840,3.6000,10.0000,-0.0006,-0.0215},
				{0.0200,2.0099,7.4932,0.7600,3.8000,9.9999,-0.0007,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,9.9999,-0.0007,-0.0263},
				{0.0200,2.0899,7.4909,0.8400,4.0000,9.9999,-0.0009,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,9.9999,-0.0009,-0.0319},
				{0.0200,2.1739,7.4879,0.9240,4.2000,9.9999,-0.0011,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,9.9999,-0.0011,-0.0382},
				{0.0200,2.2618,7.4842,1.0120,4.4000,9.9999,-0.0013,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,9.9999,-0.0013,-0.0454},
				{0.0200,2.3537,7.4797,1.1040,4.6000,9.9998,-0.0016,1.1040,4.6000,10.0000,0.0000,1.1040,4.6000,9.9998,-0.0016,-0.0535},
				{0.0200,2.4495,7.4741,1.2000,4.8000,9.9998,-0.0019,1.2000,4.8000,10.0000,0.0000,1.2000,4.8000,9.9998,-0.0019,-0.0625},
				{0.0200,2.5493,7.4674,1.3000,5.0000,9.9998,-0.0022,1.3000,5.0000,10.0000,0.0000,1.3000,5.0000,9.9998,-0.0022,-0.0726},
				{0.0200,2.6530,7.4593,1.4040,5.2000,9.9997,-0.0026,1.4040,5.2000,10.0000,0.0000,1.4040,5.2000,9.9997,-0.0026,-0.0838},
				{0.0200,2.7605,7.4496,1.5120,5.4000,9.9997,-0.0029,1.5120,5.4000,10.0000,0.0000,1.5120,5.4000,9.9997,-0.0029,-0.0960},
				{0.0200,2.8719,7.4381,1.6240,5.6000,9.9996,-0.0032,1.6240,5.6000,10.0000,0.0000,1.6240,5.6000,9.9996,-0.0032,-0.1095},
				{0.0200,2.9871,7.4246,1.7400,5.7999,9.9995,-0.0035,1.7400,5.8000,10.0000,0.0000,1.7400,5.7999,9.9995,-0.0035,-0.1241},
				{0.0200,3.1061,7.4088,1.8600,5.9999,9.9994,-0.0036,1.8600,6.0000,10.0000,0.0000,1.8600,5.9999,9.9994,-0.0036,-0.1399},
				{0.0200,3.2287,7.3905,1.9840,6.1999,9.9994,-0.0038,1.9840,6.2000,10.0000,0.0000,1.9840,6.1999,9.9994,-0.0038,-0.1570},
				{0.0200,3.3550,7.3693,2.1120,6.3999,9.9993,-0.0037,2.1120,6.4000,10.0000,0.0000,2.1120,6.3999,9.9993,-0.0037,-0.1753},
				{0.0200,3.4847,7.3450,2.2440,6.5999,9.9992,-0.0034,2.2440,6.6000,10.0000,0.0000,2.2440,6.5999,9.9992,-0.0034,-0.1948},
				{0.0200,3.6179,7.3173,2.3800,6.7999,9.9992,-0.0029,2.3800,6.8000,10.0000,0.0000,2.3800,6.7999,9.9992,-0.0029,-0.2156},
				{0.0200,3.7543,7.2859,2.5200,6.9999,9.9991,-0.0021,2.5200,7.0000,10.0000,0.0000,2.5200,6.9999,9.9991,-0.0021,-0.2374},
				{0.0200,3.8939,7.2504,2.6640,7.1998,9.9991,-0.0010,2.6640,7.2000,10.0000,0.0000,2.6640,7.1998,9.9991,-0.0010,-0.2602},
				{0.0200,4.0364,7.2107,2.8120,7.3998,9.9991,0.0004,2.8120,7.4000,10.0000,0.0000,2.8120,7.3998,9.9991,0.0004,-0.2840},
				{0.0200,4.1818,7.1663,2.9640,7.5998,9.9992,0.0020,2.9640,7.6000,10.0000,0.0000,2.9640,7.5998,9.9992,0.0020,-0.3086},
				{0.0200,4.3298,7.1170,3.1200,7.7998,9.9992,0.0038,3.1200,7.8000,10.0000,0.0000,3.1200,7.7998,9.9992,0.0038,-0.3338},
				{0.0200,4.4803,7.0627,3.2800,7.9998,9.9993,0.0057,3.2800,8.0000,10.0000,0.0000,3.2800,7.9998,9.9993,0.0057,-0.3595},
				{0.0200,4.6330,7.0030,3.4440,8.1998,9.9995,0.0075,3.4440,8.2000,10.0000,0.0000,3.4440,8.1998,9.9995,0.0075,-0.3854},
				{0.0200,4.7879,6.9378,3.6120,8.3998,9.9997,0.0092,3.6120,8.4000,10.0000,0.0000,3.6120,8.3998,9.9997,0.0092,-0.4114},
				{0.0200,4.9446,6.8670,3.7840,8.5998,9.9999,0.0104,3.7840,8.6000,10.0000,0.0000,3.7840,8.5998,9.9999,0.0104,-0.4372},
				{0.0200,5.1031,6.7904,3.9599,8.7998,10.0001,0.0112,3.9600,8.8000,10.0000,0.0000,3.9599,8.7998,10.0001,0.0112,-0.4626},
				{0.0200,5.2631,6.7081,4.1399,8.9998,10.0003,0.0114,4.1400,9.0000,10.0000,0.0000,4.1399,8.9998,10.0003,0.0114,-0.4873},
				{0.0200,5.4247,6.6200,4.3239,9.1998,10.0006,0.0110,4.3240,9.2000,10.0000,0.0000,4.3239,9.1998,10.0006,0.0110,-0.5112},
				{0.0200,5.5876,6.5261,4.5119,9.3998,10.0008,0.0101,4.5120,9.4000,10.0000,0.0000,4.5119,9.3998,10.0008,0.0101,-0.5340},
				{0.0200,5.7517,6.4266,4.7039,9.5998,10.0009,0.0087,4.7040,9.6000,10.0000,0.0000,4.7039,9.5998,10.0009,0.0087,-0.5554},
				{0.0200,5.9172,6.3216,4.8999,9.7998,10.0011,0.0068,4.9000,9.8000,10.0000,0.0000,4.8999,9.7998,10.0011,0.0068,-0.5754},
				{0.0200,6.0840,6.2112,5.0999,9.9999,10.0012,0.0048,5.1000,10.0000,10.0000,0.0000,5.0999,9.9999,10.0012,0.0048,-0.5938},
				{0.0200,6.2521,6.0956,5.3039,10.1999,10.0012,0.0025,5.3040,10.2000,10.0000,0.0000,5.3039,10.1999,10.0012,0.0025,-0.6102},
				{0.0200,6.4217,5.9752,5.5119,10.3999,10.0012,0.0001,5.5120,10.4000,10.0000,0.0000,5.5119,10.3999,10.0012,0.0001,-0.6247},
				{0.0200,6.5928,5.8501,5.7239,10.5999,10.0012,-0.0022,5.7240,10.6000,10.0000,0.0000,5.7239,10.5999,10.0012,-0.0022,-0.6371},
				{0.0200,6.7658,5.7207,5.9399,10.8000,10.0011,-0.0047,5.9400,10.8000,10.0000,0.0000,5.9399,10.8000,10.0011,-0.0047,-0.6473},
				{0.0200,6.9407,5.5873,6.1599,11.0000,10.0009,-0.0072,6.1600,11.0000,10.0000,0.0000,6.1599,11.0000,10.0009,-0.0072,-0.6550},
				{0.0200,7.1180,5.4503,6.3839,11.2000,10.0007,-0.0099,6.3840,11.2000,10.0000,0.0000,6.3839,11.2000,10.0007,-0.0099,-0.6602},
				{0.0200,7.2979,5.3102,6.6119,11.4000,10.0005,-0.0129,6.6120,11.4000,10.0000,0.0000,6.6119,11.4000,10.0005,-0.0129,-0.6628},
				{0.0200,7.4807,5.1675,6.8439,11.6000,10.0002,-0.0162,6.8440,11.6000,10.0000,0.0000,6.8439,11.6000,10.0002,-0.0162,-0.6626},
				{0.0200,7.6670,5.0225,7.0799,11.8000,9.9998,-0.0200,7.0800,11.8000,10.0000,0.0000,7.0799,11.8000,9.9998,-0.0200,-0.6594},
				{0.0200,7.8571,4.8761,7.3199,12.0000,9.9993,-0.0245,7.3200,12.0000,10.0000,0.0000,7.3199,12.0000,9.9993,-0.0245,-0.6531},
				{0.0200,8.0483,4.7311,7.5599,12.0000,-0.0012,-500.0234,7.5600,12.0000,10.0000,0.0000,7.5599,12.0000,-0.0012,-500.0234,-0.6438},
				{0.0200,8.2411,4.5881,7.7999,11.9999,-0.0017,-0.0242,7.8000,12.0000,10.0000,0.0000,7.7999,11.9999,-0.0017,-0.0242,-0.6313},
				{0.0200,8.4359,4.4479,8.0399,11.9999,-0.0022,-0.0244,8.0400,12.0000,10.0000,0.0000,8.0399,11.9999,-0.0022,-0.0244,-0.6158},
				{0.0200,8.6298,4.3134,8.2759,11.7998,-10.0022,-500.0014,8.2760,11.8000,-10.0000,0.0000,8.2759,11.7998,-10.0022,-500.0014,-0.5975},
				{0.0200,8.8229,4.1848,8.5079,11.5998,-10.0023,-0.0057,8.5080,11.6000,-10.0000,0.0000,8.5079,11.5998,-10.0023,-0.0057,-0.5766},
				{0.0200,9.0155,4.0627,8.7359,11.3997,-10.0023,-0.0006,8.7360,11.4000,-10.0000,0.0000,8.7359,11.3997,-10.0023,-0.0006,-0.5533},
				{0.0200,9.2075,3.9474,8.9599,11.1997,-10.0022,0.0048,8.9600,11.2000,-10.0000,0.0000,8.9599,11.1997,-10.0022,0.0048,-0.5278},
				{0.0200,9.3990,3.8392,9.1799,10.9997,-10.0020,0.0103,9.1800,11.0000,-10.0000,0.0000,9.1799,10.9997,-10.0020,0.0103,-0.5004},
				{0.0200,9.5900,3.7383,9.3959,10.7996,-10.0017,0.0156,9.3960,10.8000,-10.0000,0.0000,9.3959,10.7996,-10.0017,0.0156,-0.4715},
				{0.0200,9.7803,3.6448,9.6079,10.5996,-10.0013,0.0203,9.6080,10.6000,-10.0000,0.0000,9.6079,10.5996,-10.0013,0.0203,-0.4413},
				{0.0200,9.9697,3.5589,9.8159,10.3996,-10.0008,0.0238,9.8160,10.4000,-10.0000,0.0000,9.8159,10.3996,-10.0008,0.0238,-0.4101},
				{0.0200,10.1580,3.4805,10.0199,10.1996,-10.0003,0.0259,10.0200,10.2000,-10.0000,0.0000,10.0199,10.1996,-10.0003,0.0259,-0.3785},
				{0.0200,10.3450,3.4096,10.2198,9.9996,-9.9998,0.0261,10.2200,10.0000,-10.0000,0.0000,10.2198,9.9996,-9.9998,0.0261,-0.3466},
				{0.0200,10.5304,3.3459,10.4158,9.7996,-9.9993,0.0245,10.4160,9.8000,-10.0000,0.0000,10.4158,9.7996,-9.9993,0.0245,-0.3150},
				{0.0200,10.7138,3.2893,10.6078,9.5996,-9.9989,0.0214,10.6080,9.6000,-10.0000,0.0000,10.6078,9.5996,-9.9989,0.0214,-0.2840},
				{0.0200,10.8951,3.2393,10.7958,9.3996,-9.9985,0.0170,10.7960,9.4000,-10.0000,0.0000,10.7958,9.3996,-9.9985,0.0170,-0.2538},
				{0.0200,11.0738,3.1957,10.9798,9.1997,-9.9983,0.0120,10.9800,9.2000,-10.0000,0.0000,10.9798,9.1997,-9.9983,0.0120,-0.2248},
				{0.0200,11.2498,3.1581,11.1598,8.9997,-9.9982,0.0069,11.1600,9.0000,-10.0000,0.0000,11.1598,8.9997,-9.9982,0.0069,-0.1972},
				{0.0200,11.4228,3.1258,11.3358,8.7998,-9.9981,0.0022,11.3360,8.8000,-10.0000,0.0000,11.3358,8.7998,-9.9981,0.0022,-0.1712},
				{0.0200,11.5927,3.0986,11.5078,8.5998,-9.9982,-0.0018,11.5080,8.6000,-10.0000,0.0000,11.5078,8.5998,-9.9982,-0.0018,-0.1470},
				{0.0200,11.7591,3.0759,11.6758,8.3998,-9.9982,-0.0050,11.6760,8.4000,-10.0000,0.0000,11.6758,8.3998,-9.9982,-0.0050,-0.1246},
				{0.0200,11.9221,3.0572,11.8398,8.1999,-9.9984,-0.0072,11.8400,8.2000,-10.0000,0.0000,11.8398,8.1999,-9.9984,-0.0072,-0.1041},
				{0.0200,12.0813,3.0421,11.9998,7.9999,-9.9986,-0.0085,12.0000,8.0000,-10.0000,0.0000,11.9998,7.9999,-9.9986,-0.0085,-0.0855},
				{0.0200,12.2369,3.0301,12.1558,7.7999,-9.9987,-0.0092,12.1560,7.8000,-10.0000,0.0000,12.1558,7.7999,-9.9987,-0.0092,-0.0689},
				{0.0200,12.3886,3.0207,12.3078,7.5999,-9.9989,-0.0092,12.3080,7.6000,-10.0000,0.0000,12.3078,7.5999,-9.9989,-0.0092,-0.0542},
				{0.0200,12.5364,3.0137,12.4558,7.3999,-9.9991,-0.0089,12.4560,7.4000,-10.0000,0.0000,12.4558,7.3999,-9.9991,-0.0089,-0.0414},
				{0.0200,12.6803,3.0085,12.5998,7.2000,-9.9993,-0.0083,12.6000,7.2000,-10.0000,0.0000,12.5998,7.2000,-9.9993,-0.0083,-0.0304},
				{0.0200,12.8203,3.0049,12.7398,7.0000,-9.9994,-0.0075,12.7400,7.0000,-10.0000,0.0000,12.7398,7.0000,-9.9994,-0.0075,-0.0213},
				{0.0200,12.9563,3.0025,12.8758,6.8000,-9.9996,-0.0067,12.8760,6.8000,-10.0000,0.0000,12.8758,6.8000,-9.9996,-0.0067,-0.0138},
				{0.0200,13.0882,3.0011,13.0078,6.6000,-9.9997,-0.0058,13.0080,6.6000,-10.0000,0.0000,13.0078,6.6000,-9.9997,-0.0058,-0.0081},
				{0.0200,13.2162,3.0004,13.1358,6.4000,-9.9998,-0.0050,13.1360,6.4000,-10.0000,0.0000,13.1358,6.4000,-9.9998,-0.0050,-0.0039},
				{0.0200,13.3402,3.0001,13.2598,6.2000,-9.9999,-0.0042,13.2600,6.2000,-10.0000,0.0000,13.2598,6.2000,-9.9999,-0.0042,-0.0013},
				{0.0200,13.4602,3.0000,13.3798,6.0000,-9.9999,-0.0035,13.3800,6.0000,-10.0000,0.0000,13.3798,6.0000,-9.9999,-0.0035,-0.0001},
				{0.0200,13.5000,3.0000,13.4195,1.9878,-200.6081,-9530.4099,13.4198,5.8000,-10.0000,0.0000,13.4195,1.9878,-200.6081,-9530.4099,0.0000},
				{0.0200,13.6200,3.0001,13.5395,6.0000,200.6080,20060.8058,13.5398,6.0000,10.0000,0.0000,13.5395,6.0000,200.6080,20060.8058,0.0034},
				{0.0200,13.7400,3.0011,13.6595,6.0000,-0.0011,-10030.4534,13.6598,6.0000,10.0000,0.0000,13.6595,6.0000,-0.0011,-10030.4534,0.0133},
				{0.0200,13.8600,3.0036,13.7795,5.9999,-0.0021,-0.0519,13.7798,6.0000,10.0000,0.0000,13.7795,5.9999,-0.0021,-0.0519,0.0296},
				{0.0200,13.9799,3.0084,13.8995,5.9999,-0.0033,-0.0610,13.8998,6.0000,10.0000,0.0000,13.8995,5.9999,-0.0033,-0.0610,0.0527},
				{0.0200,14.0996,3.0165,14.0195,5.9998,-0.0050,-0.0818,14.0198,6.0000,10.0000,0.0000,14.0195,5.9998,-0.0050,-0.0818,0.0833},
				{0.0200,14.2190,3.0287,14.1395,5.9996,-0.0073,-0.1161,14.1398,6.0000,10.0000,0.0000,14.1395,5.9996,-0.0073,-0.1161,0.1222},
				{0.0200,14.3377,3.0461,14.2595,5.9994,-0.0106,-0.1672,14.2598,6.0000,10.0000,0.0000,14.2595,5.9994,-0.0106,-0.1672,0.1709},
				{0.0200,14.4553,3.0700,14.3795,5.9991,-0.0154,-0.2361,14.3798,6.0000,10.0000,0.0000,14.3795,5.9991,-0.0154,-0.2361,0.2308},
				{0.0200,14.5710,3.1015,14.4995,5.9987,-0.0216,-0.3132,14.4998,6.0000,10.0000,0.0000,14.4995,5.9987,-0.0216,-0.3132,0.3038},
				{0.0200,14.6839,3.1422,14.6194,5.9981,-0.0288,-0.3607,14.6198,6.0000,10.0000,0.0000,14.6194,5.9981,-0.0288,-0.3607,0.3912},
				{0.0200,14.7923,3.1934,14.7394,5.9974,-0.0347,-0.2921,14.7398,6.0000,10.0000,0.0000,14.7394,5.9974,-0.0347,-0.2921,0.4931},
				{0.0200,14.8946,3.2561,14.8593,5.9967,-0.0345,0.0093,14.8598,6.0000,10.0000,0.0000,14.8593,5.9967,-0.0345,0.0093,0.6078},
				{0.0200,14.9887,3.3304,14.9792,5.9962,-0.0234,0.5553,14.9798,6.0000,10.0000,0.0000,14.9792,5.9962,-0.0234,0.5553,0.7303},
				{0.0200,15.0729,3.4158,15.0992,5.9962,-0.0020,1.0685,15.0998,6.0000,10.0000,0.0000,15.0992,5.9962,-0.0020,1.0685,0.8535},
				{0.0200,15.1463,3.5107,15.2191,5.9966,0.0205,1.1268,15.2198,6.0000,10.0000,0.0000,15.2191,5.9966,0.0205,1.1268,0.9698},
				{0.0200,15.2088,3.6131,15.3390,5.9973,0.0340,0.6716,15.3398,6.0000,10.0000,0.0000,15.3390,5.9973,0.0340,0.6716,1.0739},
				{0.0200,15.2610,3.7210,15.4590,5.9980,0.0358,0.0917,15.4598,6.0000,10.0000,0.0000,15.4590,5.9980,0.0358,0.0917,1.1632},
				{0.0200,15.3043,3.8329,15.5790,5.9986,0.0304,-0.2701,15.5798,6.0000,10.0000,0.0000,15.5790,5.9986,0.0304,-0.2701,1.2377},
				{0.0200,15.3400,3.9475,15.6990,5.9991,0.0229,-0.3757,15.6998,6.0000,10.0000,0.0000,15.6990,5.9991,0.0229,-0.3757,1.2987},
				{0.0200,15.3692,4.0639,15.8189,5.9994,0.0161,-0.3386,15.8198,6.0000,10.0000,0.0000,15.8189,5.9994,0.0161,-0.3386,1.3480},
				{0.0200,15.3934,4.1814,15.9389,5.9996,0.0109,-0.2585,15.9398,6.0000,10.0000,0.0000,15.9389,5.9996,0.0109,-0.2585,1.3875},
				{0.0200,15.4133,4.2997,16.0589,5.9998,0.0073,-0.1828,16.0598,6.0000,10.0000,0.0000,16.0589,5.9998,0.0073,-0.1828,1.4187},
				{0.0200,15.4300,4.4186,16.1789,5.9999,0.0048,-0.1249,16.1798,6.0000,10.0000,0.0000,16.1789,5.9999,0.0048,-0.1249,1.4430},
				{0.0200,15.4441,4.5377,16.2989,5.9999,0.0031,-0.0843,16.2998,6.0000,10.0000,0.0000,16.2989,5.9999,0.0031,-0.0843,1.4616},
				{0.0200,15.4563,4.6571,16.4189,6.0000,0.0020,-0.0567,16.4198,6.0000,10.0000,0.0000,16.4189,6.0000,0.0020,-0.0567,1.4754},
				{0.0200,15.4671,4.7766,16.5389,6.0000,0.0012,-0.0382,16.5398,6.0000,10.0000,0.0000,16.5389,6.0000,0.0012,-0.0382,1.4851},
				{0.0200,15.4770,4.8962,16.6589,6.0000,0.0007,-0.0256,16.6598,6.0000,10.0000,0.0000,16.6589,6.0000,0.0007,-0.0256,1.4915},
				{0.0200,15.4863,5.0158,16.7789,6.0000,0.0003,-0.0167,16.7798,6.0000,10.0000,0.0000,16.7789,6.0000,0.0003,-0.0167,1.4951},
				{0.0200,15.4952,5.1355,16.8989,6.0000,0.0001,-0.0102,16.8998,6.0000,10.0000,0.0000,16.8989,6.0000,0.0001,-0.0102,1.4967},
				{0.0200,15.5041,5.2552,17.0189,6.0000,-0.0000,-0.0072,17.0198,6.0000,10.0000,0.0000,17.0189,6.0000,-0.0000,-0.0072,1.4987},
				{0.0200,15.5119,5.3749,17.1389,5.9999,-0.0033,-0.1628,17.1398,6.0000,10.0000,0.0000,17.1389,5.9999,-0.0033,-0.1628,1.5148},
				{0.0200,15.5168,5.4948,17.2589,5.9997,-0.0096,-0.3175,17.2598,6.0000,10.0000,0.0000,17.2589,5.9997,-0.0096,-0.3175,1.5469},
				{0.0200,15.5170,5.6148,17.3789,5.9994,-0.0164,-0.3380,17.3798,6.0000,10.0000,0.0000,17.3789,5.9994,-0.0164,-0.3380,1.5953},
				{0.0200,15.5103,5.7346,17.4989,5.9989,-0.0246,-0.4109,17.4998,6.0000,10.0000,0.0000,17.4989,5.9989,-0.0246,-0.4109,1.6609},
				{0.0200,15.4947,5.8535,17.6188,5.9982,-0.0338,-0.4617,17.6198,6.0000,10.0000,0.0000,17.6188,5.9982,-0.0338,-0.4617,1.7447},
				{0.0200,15.4681,5.9705,17.7388,5.9974,-0.0409,-0.3522,17.7398,6.0000,10.0000,0.0000,17.7388,5.9974,-0.0409,-0.3522,1.8460},
				{0.0200,15.4290,6.0839,17.8587,5.9966,-0.0391,0.0880,17.8598,6.0000,10.0000,0.0000,17.8587,5.9966,-0.0391,0.0880,1.9617},
				{0.0200,15.3766,6.1918,17.9787,5.9962,-0.0225,0.8287,17.9798,6.0000,10.0000,0.0000,17.9787,5.9962,-0.0225,0.8287,2.0849},
				{0.0200,15.3114,6.2924,18.0986,5.9963,0.0053,1.3911,18.0998,6.0000,10.0000,0.0000,18.0986,5.9963,0.0053,1.3911,2.2064},
				{0.0200,15.2348,6.3847,18.2185,5.9969,0.0301,1.2403,18.2198,6.0000,10.0000,0.0000,18.2185,5.9969,0.0301,1.2403,2.3177},
				{0.0200,15.1491,6.4686,18.3385,5.9977,0.0407,0.5285,18.3398,6.0000,10.0000,0.0000,18.3385,5.9977,0.0407,0.5285,2.4132},
				{0.0200,15.0564,6.5448,18.4584,5.9985,0.0380,-0.1310,18.4598,6.0000,10.0000,0.0000,18.4584,5.9985,0.0380,-0.1310,2.4912},
				{0.0200,14.9586,6.6143,18.5784,5.9991,0.0295,-0.4286,18.5798,6.0000,10.0000,0.0000,18.5784,5.9991,0.0295,-0.4286,2.5524},
				{0.0200,14.8573,6.6786,18.6984,5.9995,0.0205,-0.4489,18.6998,6.0000,10.0000,0.0000,18.6984,5.9995,0.0205,-0.4489,2.5982},
				{0.0200,14.7535,6.7389,18.8184,5.9997,0.0133,-0.3615,18.8198,6.0000,10.0000,0.0000,18.8184,5.9997,0.0133,-0.3615,2.6303},
				{0.0200,14.6482,6.7964,18.9384,5.9999,0.0079,-0.2655,18.9398,6.0000,10.0000,0.0000,18.9384,5.9999,0.0079,-0.2655,2.6503},
				{0.0200,14.5421,6.8525,19.0584,6.0000,0.0040,-0.1955,19.0598,6.0000,10.0000,0.0000,19.0584,6.0000,0.0040,-0.1955,2.6591},
				{0.0200,14.4358,6.9082,19.1784,6.0000,0.0009,-0.1569,19.1798,6.0000,10.0000,0.0000,19.1784,6.0000,0.0009,-0.1569,2.6570},
				{0.0200,14.3300,6.9647,19.2984,6.0000,-0.0021,-0.1476,19.2998,6.0000,10.0000,0.0000,19.2984,6.0000,-0.0021,-0.1476,2.6440},
				{0.0200,14.2252,7.0231,19.4184,5.9998,-0.0054,-0.1666,19.4198,6.0000,10.0000,0.0000,19.4184,5.9998,-0.0054,-0.1666,2.6195},
				{0.0200,14.1222,7.0848,19.5384,5.9997,-0.0097,-0.2151,19.5398,6.0000,10.0000,0.0000,19.5384,5.9997,-0.0097,-0.2151,2.5824},
				{0.0200,14.0221,7.1509,19.6584,5.9993,-0.0155,-0.2928,19.6598,6.0000,10.0000,0.0000,19.6584,5.9993,-0.0155,-0.2928,2.5312},
				{0.0200,13.9260,7.2228,19.7784,5.9989,-0.0233,-0.3857,19.7798,6.0000,10.0000,0.0000,19.7784,5.9989,-0.0233,-0.3857,2.4643},
				{0.0200,13.8357,7.3017,19.8983,5.9982,-0.0320,-0.4396,19.8998,6.0000,10.0000,0.0000,19.8983,5.9982,-0.0320,-0.4396,2.3804},
				{0.0200,13.7530,7.3886,20.0183,5.9975,-0.0386,-0.3297,20.0198,6.0000,10.0000,0.0000,20.0183,5.9975,-0.0386,-0.3297,2.2798},
				{0.0200,13.6801,7.4838,20.1382,5.9967,-0.0367,0.0989,20.1398,6.0000,10.0000,0.0000,20.1382,5.9967,-0.0367,0.0989,2.1656},
				{0.0200,13.6191,7.5870,20.2581,5.9963,-0.0206,0.8056,20.2598,6.0000,10.0000,0.0000,20.2581,5.9963,-0.0206,0.8056,2.0445},
				{0.0200,13.5709,7.6969,20.3781,5.9964,0.0061,1.3336,20.3798,6.0000,10.0000,0.0000,20.3781,5.9964,0.0061,1.3336,1.9253},
				{0.0200,13.5355,7.8115,20.4980,5.9970,0.0299,1.1880,20.4998,6.0000,10.0000,0.0000,20.4980,5.9970,0.0299,1.1880,1.8166},
				{0.0200,13.5119,7.9291,20.6180,5.9978,0.0402,0.5148,20.6198,6.0000,10.0000,0.0000,20.6180,5.9978,0.0402,0.5148,1.7239},
				{0.0200,13.4983,8.0483,20.7379,5.9986,0.0379,-0.1151,20.7398,6.0000,10.0000,0.0000,20.7379,5.9986,0.0379,-0.1151,1.6491},
				{0.0200,13.4924,8.1681,20.8579,5.9992,0.0297,-0.4092,20.8598,6.0000,10.0000,0.0000,20.8579,5.9992,0.0297,-0.4092,1.5925},
				{0.0200,13.4924,8.2881,20.9779,5.9996,0.0208,-0.4449,20.9798,6.0000,10.0000,0.0000,20.9779,5.9996,0.0208,-0.4449,1.5532},
				{0.0200,13.4960,8.4081,21.0979,5.9999,0.0130,-0.3880,21.0998,6.0000,10.0000,0.0000,21.0979,5.9999,0.0130,-0.3880,1.5308},
				{0.0200,13.5013,8.5279,21.2179,6.0000,0.0060,-0.3541,21.2198,6.0000,10.0000,0.0000,21.2179,6.0000,0.0060,-0.3541,1.5253},
				{0.0200,13.5068,8.6478,21.3379,6.0000,0.0003,-0.2813,21.3398,6.0000,10.0000,0.0000,21.3379,6.0000,0.0003,-0.2813,1.5231},
				{0.0200,13.5128,8.7677,21.4579,6.0000,-0.0003,-0.0304,21.4598,6.0000,10.0000,0.0000,21.4579,6.0000,-0.0003,-0.0304,1.5178},
				{0.0200,13.5197,8.8875,21.5779,6.0000,-0.0005,-0.0121,21.5798,6.0000,10.0000,0.0000,21.5779,6.0000,-0.0005,-0.0121,1.5095},
				{0.0200,13.5277,9.0072,21.6979,6.0000,-0.0008,-0.0140,21.6998,6.0000,10.0000,0.0000,21.6979,6.0000,-0.0008,-0.0140,1.4979},
				{0.0200,13.5373,9.1268,21.8179,5.9999,-0.0011,-0.0171,21.8198,6.0000,10.0000,0.0000,21.8179,5.9999,-0.0011,-0.0171,1.4829},
				{0.0200,13.5489,9.2462,21.9379,5.9999,-0.0016,-0.0219,21.9398,6.0000,10.0000,0.0000,21.9379,5.9999,-0.0016,-0.0219,1.4642},
				{0.0200,13.5630,9.3654,22.0579,5.9999,-0.0022,-0.0287,22.0598,6.0000,10.0000,0.0000,22.0579,5.9999,-0.0022,-0.0287,1.4413},
				{0.0200,13.5801,9.4842,22.1779,5.9998,-0.0029,-0.0383,22.1798,6.0000,10.0000,0.0000,22.1779,5.9998,-0.0029,-0.0383,1.4137},
				{0.0200,13.6007,9.6024,22.2979,5.9997,-0.0039,-0.0512,22.2998,6.0000,10.0000,0.0000,22.2979,5.9997,-0.0039,-0.0512,1.3809},
				{0.0200,13.6256,9.7198,22.4179,5.9996,-0.0053,-0.0683,22.4198,6.0000,10.0000,0.0000,22.4179,5.9996,-0.0053,-0.0683,1.3422},
				{0.0200,13.6554,9.8360,22.5379,5.9995,-0.0071,-0.0893,22.5398,6.0000,10.0000,0.0000,22.5379,5.9995,-0.0071,-0.0893,1.2967},
				{0.0200,13.6908,9.9506,22.6579,5.9993,-0.0093,-0.1125,22.6598,6.0000,10.0000,0.0000,22.6579,5.9993,-0.0093,-0.1125,1.2437},
				{0.0200,13.7327,10.0631,22.7778,5.9991,-0.0120,-0.1323,22.7798,6.0000,10.0000,0.0000,22.7778,5.9991,-0.0120,-0.1323,1.1822},
				{0.0200,13.7820,10.1725,22.8978,5.9988,-0.0147,-0.1368,22.8998,6.0000,10.0000,0.0000,22.8978,5.9988,-0.0147,-0.1368,1.1119},
				{0.0200,13.8393,10.2779,23.0178,5.9984,-0.0169,-0.1061,23.0198,6.0000,10.0000,0.0000,23.0178,5.9984,-0.0169,-0.1061,1.0325},
				{0.0200,13.9052,10.3781,23.1377,5.9981,-0.0172,-0.0183,23.1398,6.0000,10.0000,0.0000,23.1377,5.9981,-0.0172,-0.0183,0.9449},
				{0.0200,13.9799,10.4720,23.2577,5.9978,-0.0146,0.1320,23.2598,6.0000,10.0000,0.0000,23.2577,5.9978,-0.0146,0.1320,0.8509},
				{0.0200,14.0633,10.5582,23.3777,5.9976,-0.0084,0.3079,23.3798,6.0000,10.0000,0.0000,23.3777,5.9976,-0.0084,0.3079,0.7534},
				{0.0200,14.1547,10.6359,23.4976,5.9976,0.0002,0.4300,23.4998,6.0000,10.0000,0.0000,23.4976,5.9976,0.0002,0.4300,0.6560},
				{0.0200,14.2531,10.7045,23.6176,5.9978,0.0087,0.4273,23.6198,6.0000,10.0000,0.0000,23.6176,5.9978,0.0087,0.4273,0.5622},
				{0.0200,14.3573,10.7639,23.7375,5.9981,0.0148,0.3015,23.7398,6.0000,10.0000,0.0000,23.7375,5.9981,0.0148,0.3015,0.4749},
				{0.0200,14.4661,10.8144,23.8575,5.9984,0.0173,0.1254,23.8598,6.0000,10.0000,0.0000,23.8575,5.9984,0.0173,0.1254,0.3959},
				{0.0200,14.5784,10.8567,23.9775,5.9988,0.0168,-0.0225,23.9798,6.0000,10.0000,0.0000,23.9775,5.9988,0.0168,-0.0225,0.3259},
				{0.0200,14.6932,10.8915,24.0974,5.9991,0.0147,-0.1077,24.0998,6.0000,10.0000,0.0000,24.0974,5.9991,0.0147,-0.1077,0.2649},
				{0.0200,14.8098,10.9198,24.2174,5.9993,0.0119,-0.1366,24.2198,6.0000,10.0000,0.0000,24.2174,5.9993,0.0119,-0.1366,0.2123},
				{0.0200,14.9277,10.9424,24.3374,5.9995,0.0093,-0.1313,24.3398,6.0000,10.0000,0.0000,24.3374,5.9995,0.0093,-0.1313,0.1672},
				{0.0200,15.0463,10.9600,24.4574,5.9996,0.0071,-0.1113,24.4598,6.0000,10.0000,0.0000,24.4574,5.9996,0.0071,-0.1113,0.1290},
				{0.0200,15.1656,10.9735,24.5774,5.9997,0.0053,-0.0883,24.5798,6.0000,10.0000,0.0000,24.5774,5.9997,0.0053,-0.0883,0.0969},
				{0.0200,15.2852,10.9834,24.6974,5.9998,0.0040,-0.0676,24.6998,6.0000,10.0000,0.0000,24.6974,5.9998,0.0040,-0.0676,0.0701},
				{0.0200,15.4049,10.9905,24.8174,5.9999,0.0029,-0.0509,24.8198,6.0000,10.0000,0.0000,24.8174,5.9999,0.0029,-0.0509,0.0481},
				{0.0200,15.5249,10.9951,24.9374,5.9999,0.0022,-0.0384,24.9398,6.0000,10.0000,0.0000,24.9374,5.9999,0.0022,-0.0384,0.0306},
				{0.0200,15.6448,10.9980,25.0574,6.0000,0.0016,-0.0294,25.0598,6.0000,10.0000,0.0000,25.0574,6.0000,0.0016,-0.0294,0.0171},
				{0.0200,15.7648,10.9994,25.1774,6.0000,0.0011,-0.0232,25.1798,6.0000,10.0000,0.0000,25.1774,6.0000,0.0011,-0.0232,0.0076},
				{0.0200,15.8848,10.9999,25.2974,6.0000,0.0007,-0.0196,25.2998,6.0000,10.0000,0.0000,25.2974,6.0000,0.0007,-0.0196,0.0018},
				{0.0200,16.0048,11.0000,25.4174,6.0000,0.0004,-0.0182,25.4198,6.0000,10.0000,0.0000,25.4174,6.0000,0.0004,-0.0182,-0.0000},
				{0.0200,16.1288,10.9998,25.5414,6.2000,9.9997,499.9683,25.5438,6.2000,10.0000,0.0000,25.5414,6.2000,9.9997,499.9683,-0.0048},
				{0.0200,16.2568,10.9984,25.6694,6.3999,9.9978,-0.0970,25.6718,6.4000,10.0000,0.0000,25.6694,6.3999,9.9978,-0.0970,-0.0185},
				{0.0200,16.3887,10.9945,25.8014,6.5999,9.9953,-0.1254,25.8038,6.6000,10.0000,0.0000,25.8014,6.5999,9.9953,-0.1254,-0.0414},
				{0.0200,16.5245,10.9868,25.9374,6.7997,9.9921,-0.1569,25.9398,6.8000,10.0000,0.0000,25.9374,6.7997,9.9921,-0.1569,-0.0740},
				{0.0200,16.6639,10.9736,26.0774,6.9995,9.9882,-0.1965,26.0798,7.0000,10.0000,0.0000,26.0774,6.9995,9.9882,-0.1965,-0.1169},
				{0.0200,16.8064,10.9531,26.2214,7.1991,9.9836,-0.2314,26.2238,7.2000,10.0000,0.0000,26.2214,7.1991,9.9836,-0.2314,-0.1706},
				{0.0200,16.9514,10.9233,26.3693,7.3987,9.9789,-0.2341,26.3718,7.4000,10.0000,0.0000,26.3693,7.3987,9.9789,-0.2341,-0.2352},
				{0.0200,17.0977,10.8825,26.5213,7.5982,9.9757,-0.1605,26.5238,7.6000,10.0000,0.0000,26.5213,7.5982,9.9757,-0.1605,-0.3100},
				{0.0200,17.2442,10.8289,26.6773,7.7978,9.9763,0.0290,26.6798,7.8000,10.0000,0.0000,26.6773,7.7978,9.9763,0.0290,-0.3931},
				{0.0200,17.3891,10.7612,26.8372,7.9974,9.9826,0.3185,26.8398,8.0000,10.0000,0.0000,26.8372,7.9974,9.9826,0.3185,-0.4813},
				{0.0200,17.5275,10.6810,26.9972,7.9975,0.0040,-498.9307,26.9998,8.0000,10.0000,0.0000,26.9972,7.9975,0.0040,-498.9307,-0.5681},
				{0.0200,17.6587,10.5894,27.1571,7.9978,0.0152,0.5569,27.1598,8.0000,10.0000,0.0000,27.1571,7.9978,0.0152,0.5569,-0.6495},
				{0.0200,17.7824,10.4880,27.3171,7.9982,0.0216,0.3208,27.3198,8.0000,10.0000,0.0000,27.3171,7.9982,0.0216,0.3208,-0.7225},
				{0.0200,17.8989,10.3784,27.4770,7.9987,0.0228,0.0625,27.4798,8.0000,10.0000,0.0000,27.4770,7.9987,0.0228,0.0625,-0.7855},
				{0.0200,18.0089,10.2623,27.6370,7.9991,0.0205,-0.1172,27.6398,8.0000,10.0000,0.0000,27.6370,7.9991,0.0205,-0.1172,-0.8378},
				{0.0200,18.1133,10.1411,27.7970,7.9994,0.0165,-0.1983,27.7998,8.0000,10.0000,0.0000,27.7970,7.9994,0.0165,-0.1983,-0.8796},
				{0.0200,18.2132,10.0161,27.9570,7.9997,0.0123,-0.2101,27.9598,8.0000,10.0000,0.0000,27.9570,7.9997,0.0123,-0.2101,-0.9113},
				{0.0200,18.3098,9.8885,28.1170,7.9998,0.0085,-0.1892,28.1198,8.0000,10.0000,0.0000,28.1170,7.9998,0.0085,-0.1892,-0.9336},
				{0.0200,18.4040,9.7592,28.2770,7.9999,0.0053,-0.1607,28.2798,8.0000,10.0000,0.0000,28.2770,7.9999,0.0053,-0.1607,-0.9468},
				{0.0200,18.4971,9.6291,28.4370,8.0000,0.0026,-0.1375,28.4398,8.0000,10.0000,0.0000,28.4370,8.0000,0.0026,-0.1375,-0.9514},
				{0.0200,18.5902,9.4989,28.5970,8.0000,0.0001,-0.1249,28.5998,8.0000,10.0000,0.0000,28.5970,8.0000,0.0001,-0.1249,-0.9474},
				{0.0200,18.6843,9.3695,28.7570,7.9999,-0.0024,-0.1245,28.7598,8.0000,10.0000,0.0000,28.7570,7.9999,-0.0024,-0.1245,-0.9347},
				{0.0200,18.7806,9.2418,28.9170,7.9998,-0.0051,-0.1364,28.9198,8.0000,10.0000,0.0000,28.9170,7.9998,-0.0051,-0.1364,-0.9130},
				{0.0200,18.8803,9.1167,29.0770,7.9997,-0.0083,-0.1590,29.0798,8.0000,10.0000,0.0000,29.0770,7.9997,-0.0083,-0.1590,-0.8819},
				{0.0200,18.9844,8.9952,29.2370,7.9994,-0.0121,-0.1875,29.2398,8.0000,10.0000,0.0000,29.2370,7.9994,-0.0121,-0.1875,-0.8407},
				{0.0200,19.0941,8.8787,29.3970,7.9991,-0.0163,-0.2094,29.3998,8.0000,10.0000,0.0000,29.3970,7.9991,-0.0163,-0.2094,-0.7891},
				{0.0200,19.2102,8.7686,29.5569,7.9987,-0.0203,-0.2006,29.5598,8.0000,10.0000,0.0000,29.5569,7.9987,-0.0203,-0.2006,-0.7267},
				{0.0200,19.3334,8.6666,29.7169,7.9982,-0.0228,-0.1250,29.7198,8.0000,10.0000,0.0000,29.7169,7.9982,-0.0228,-0.1250,-0.6543},
				{0.0200,19.4641,8.5744,29.8769,7.9978,-0.0218,0.0483,29.8798,8.0000,10.0000,0.0000,29.8769,7.9978,-0.0218,0.0483,-0.5734},
				{0.0200,19.6021,8.4935,30.0368,7.9975,-0.0157,0.3039,30.0398,8.0000,10.0000,0.0000,30.0368,7.9975,-0.0157,0.3039,-0.4868},
				{0.0200,19.7466,8.4250,30.1968,7.9974,-0.0048,0.5455,30.1998,8.0000,10.0000,0.0000,30.1968,7.9974,-0.0048,0.5455,-0.3986},
				{0.0200,19.8966,8.3693,30.3567,7.9976,0.0079,0.6369,30.3598,8.0000,10.0000,0.0000,30.3567,7.9976,0.0079,0.6369,-0.3131},
				{0.0200,20.0506,8.3262,30.5167,7.9979,0.0183,0.5177,30.5198,8.0000,10.0000,0.0000,30.5167,7.9979,0.0183,0.5177,-0.2343},
				{0.0200,20.2074,8.2946,30.6766,7.9984,0.0236,0.2654,30.6798,8.0000,10.0000,0.0000,30.6766,7.9984,0.0236,0.2654,-0.1650},
				{0.0200,20.3659,8.2731,30.8366,7.9989,0.0239,0.0158,30.8398,8.0000,10.0000,0.0000,30.8366,7.9989,0.0239,0.0158,-0.1069},
				{0.0200,20.5254,8.2598,30.9966,7.9993,0.0209,-0.1475,30.9998,8.0000,10.0000,0.0000,30.9966,7.9993,0.0209,-0.1475,-0.0610},
				{0.0200,20.6852,8.2529,31.1566,7.9996,0.0165,-0.2214,31.1598,8.0000,10.0000,0.0000,31.1566,7.9996,0.0165,-0.2214,-0.0275},
				{0.0200,20.8452,8.2504,31.3166,7.9999,0.0116,-0.2452,31.3198,8.0000,10.0000,0.0000,31.3166,7.9999,0.0116,-0.2452,-0.0069},
				{0.0200,21.0052,8.2500,31.4766,8.0000,0.0063,-0.2666,31.4798,8.0000,10.0000,0.0000,31.4766,8.0000,0.0063,-0.2666,0.0000},
				{0.0200,21.1692,8.2500,31.6406,8.2000,10.0008,499.7281,31.6438,8.2000,10.0000,0.0000,31.6406,8.2000,10.0008,499.7281,0.0000},
				{0.0200,21.3372,8.2500,31.8086,8.4000,10.0000,-0.0424,31.8118,8.4000,10.0000,0.0000,31.8086,8.4000,10.0000,-0.0424,0.0000},
				{0.0200,21.5092,8.2500,31.9806,8.6000,10.0000,-0.0000,31.9838,8.6000,10.0000,0.0000,31.9806,8.6000,10.0000,-0.0000,0.0000},
				{0.0200,21.6852,8.2500,32.1566,8.8000,10.0000,0.0000,32.1598,8.8000,10.0000,0.0000,32.1566,8.8000,10.0000,0.0000,0.0000},
				{0.0200,21.8652,8.2500,32.3366,9.0000,10.0000,-0.0000,32.3398,9.0000,10.0000,0.0000,32.3366,9.0000,10.0000,-0.0000,0.0000},
				{0.0200,22.0492,8.2500,32.5206,9.2000,10.0000,-0.0000,32.5238,9.2000,10.0000,0.0000,32.5206,9.2000,10.0000,-0.0000,0.0000},
				{0.0200,22.2372,8.2500,32.7086,9.4000,10.0000,-0.0000,32.7118,9.4000,10.0000,0.0000,32.7086,9.4000,10.0000,-0.0000,0.0000},
				{0.0200,22.4292,8.2500,32.9006,9.6000,10.0000,0.0000,32.9038,9.6000,10.0000,0.0000,32.9006,9.6000,10.0000,0.0000,0.0000},
				{0.0200,22.6252,8.2500,33.0966,9.8000,10.0000,0.0000,33.0998,9.8000,10.0000,0.0000,33.0966,9.8000,10.0000,0.0000,0.0000},
				{0.0200,22.8252,8.2500,33.2966,10.0000,10.0000,0.0000,33.2998,10.0000,10.0000,0.0000,33.2966,10.0000,10.0000,0.0000,0.0000},
				{0.0200,23.0292,8.2500,33.5006,10.2000,10.0000,-0.0000,33.5038,10.2000,10.0000,0.0000,33.5006,10.2000,10.0000,-0.0000,0.0000},
				{0.0200,23.2372,8.2500,33.7086,10.4000,10.0000,0.0000,33.7118,10.4000,10.0000,0.0000,33.7086,10.4000,10.0000,0.0000,0.0000},
				{0.0200,23.4492,8.2500,33.9206,10.6000,10.0000,0.0000,33.9238,10.6000,10.0000,0.0000,33.9206,10.6000,10.0000,0.0000,0.0000},
				{0.0200,23.6652,8.2500,34.1366,10.8000,10.0000,-0.0000,34.1398,10.8000,10.0000,0.0000,34.1366,10.8000,10.0000,-0.0000,0.0000},
				{0.0200,23.8852,8.2500,34.3566,11.0000,10.0000,0.0000,34.3598,11.0000,10.0000,0.0000,34.3566,11.0000,10.0000,0.0000,0.0000},
				{0.0200,24.1092,8.2500,34.5806,11.2000,10.0000,0.0000,34.5838,11.2000,10.0000,0.0000,34.5806,11.2000,10.0000,0.0000,0.0000},
				{0.0200,24.3292,8.2500,34.8006,11.0000,-10.0000,-1000.0000,34.8038,11.0000,-10.0000,0.0000,34.8006,11.0000,-10.0000,-1000.0000,0.0000},
				{0.0200,24.5452,8.2500,35.0166,10.8000,-10.0000,-0.0000,35.0198,10.8000,-10.0000,0.0000,35.0166,10.8000,-10.0000,-0.0000,0.0000},
				{0.0200,24.7572,8.2500,35.2286,10.6000,-10.0000,0.0000,35.2318,10.6000,-10.0000,0.0000,35.2286,10.6000,-10.0000,0.0000,0.0000},
				{0.0200,24.9652,8.2500,35.4366,10.4000,-10.0000,-0.0000,35.4398,10.4000,-10.0000,0.0000,35.4366,10.4000,-10.0000,-0.0000,0.0000},
				{0.0200,25.1692,8.2500,35.6406,10.2000,-10.0000,0.0000,35.6438,10.2000,-10.0000,0.0000,35.6406,10.2000,-10.0000,0.0000,0.0000},
				{0.0200,25.3692,8.2500,35.8406,10.0000,-10.0000,-0.0000,35.8438,10.0000,-10.0000,0.0000,35.8406,10.0000,-10.0000,-0.0000,0.0000},
				{0.0200,25.5652,8.2500,36.0366,9.8000,-10.0000,0.0000,36.0398,9.8000,-10.0000,0.0000,36.0366,9.8000,-10.0000,0.0000,0.0000},
				{0.0200,25.7572,8.2500,36.2286,9.6000,-10.0000,0.0000,36.2318,9.6000,-10.0000,0.0000,36.2286,9.6000,-10.0000,0.0000,0.0000},
				{0.0200,25.9452,8.2500,36.4166,9.4000,-10.0000,-0.0000,36.4198,9.4000,-10.0000,0.0000,36.4166,9.4000,-10.0000,-0.0000,0.0000},
				{0.0200,26.1292,8.2500,36.6006,9.2000,-10.0000,0.0000,36.6038,9.2000,-10.0000,0.0000,36.6006,9.2000,-10.0000,0.0000,0.0000},
				{0.0200,26.3092,8.2500,36.7806,9.0000,-10.0000,0.0000,36.7838,9.0000,-10.0000,0.0000,36.7806,9.0000,-10.0000,0.0000,0.0000},
				{0.0200,26.4852,8.2500,36.9566,8.8000,-10.0000,0.0000,36.9598,8.8000,-10.0000,0.0000,36.9566,8.8000,-10.0000,0.0000,0.0000},
				{0.0200,26.6572,8.2500,37.1286,8.6000,-10.0000,-0.0000,37.1318,8.6000,-10.0000,0.0000,37.1286,8.6000,-10.0000,-0.0000,0.0000},
				{0.0200,26.8252,8.2500,37.2966,8.4000,-10.0000,0.0000,37.2998,8.4000,-10.0000,0.0000,37.2966,8.4000,-10.0000,0.0000,0.0000},
				{0.0200,26.9892,8.2500,37.4606,8.2000,-10.0000,-0.0000,37.4638,8.2000,-10.0000,0.0000,37.4606,8.2000,-10.0000,-0.0000,0.0000},
				{0.0200,27.1492,8.2500,37.6206,8.0000,-10.0000,-0.0000,37.6238,8.0000,-10.0000,0.0000,37.6206,8.0000,-10.0000,-0.0000,0.0000},
				{0.0200,27.3052,8.2500,37.7766,7.8000,-10.0000,0.0000,37.7798,7.8000,-10.0000,0.0000,37.7766,7.8000,-10.0000,0.0000,0.0000},
				{0.0200,27.4572,8.2500,37.9286,7.6000,-10.0000,-0.0000,37.9318,7.6000,-10.0000,0.0000,37.9286,7.6000,-10.0000,-0.0000,0.0000},
				{0.0200,27.6052,8.2500,38.0766,7.4000,-10.0000,0.0000,38.0798,7.4000,-10.0000,0.0000,38.0766,7.4000,-10.0000,0.0000,0.0000},
				{0.0200,27.7492,8.2500,38.2206,7.2000,-10.0000,-0.0000,38.2238,7.2000,-10.0000,0.0000,38.2206,7.2000,-10.0000,-0.0000,0.0000},
				{0.0200,27.8892,8.2500,38.3606,7.0000,-10.0000,0.0000,38.3638,7.0000,-10.0000,0.0000,38.3606,7.0000,-10.0000,0.0000,0.0000},
				{0.0200,28.0252,8.2500,38.4966,6.8000,-10.0000,0.0000,38.4998,6.8000,-10.0000,0.0000,38.4966,6.8000,-10.0000,0.0000,0.0000},
				{0.0200,28.1572,8.2500,38.6286,6.6000,-10.0000,-0.0000,38.6318,6.6000,-10.0000,0.0000,38.6286,6.6000,-10.0000,-0.0000,0.0000},
				{0.0200,28.2852,8.2500,38.7566,6.4000,-10.0000,0.0000,38.7598,6.4000,-10.0000,0.0000,38.7566,6.4000,-10.0000,0.0000,0.0000},
				{0.0200,28.4092,8.2500,38.8806,6.2000,-10.0000,0.0000,38.8838,6.2000,-10.0000,0.0000,38.8806,6.2000,-10.0000,0.0000,0.0000},
				{0.0200,28.5292,8.2500,39.0006,6.0000,-10.0000,-0.0000,39.0038,6.0000,-10.0000,0.0000,39.0006,6.0000,-10.0000,-0.0000,0.0000},
				{0.0200,28.6452,8.2500,39.1166,5.8000,-10.0000,0.0000,39.1198,5.8000,-10.0000,0.0000,39.1166,5.8000,-10.0000,0.0000,0.0000},
				{0.0200,28.7572,8.2500,39.2286,5.6000,-10.0000,-0.0000,39.2318,5.6000,-10.0000,0.0000,39.2286,5.6000,-10.0000,-0.0000,0.0000},
				{0.0200,28.8652,8.2500,39.3366,5.4000,-10.0000,0.0000,39.3398,5.4000,-10.0000,0.0000,39.3366,5.4000,-10.0000,0.0000,0.0000},
				{0.0200,28.9692,8.2500,39.4406,5.2000,-10.0000,0.0000,39.4438,5.2000,-10.0000,0.0000,39.4406,5.2000,-10.0000,0.0000,0.0000},
				{0.0200,29.0692,8.2500,39.5406,5.0000,-10.0000,0.0000,39.5438,5.0000,-10.0000,0.0000,39.5406,5.0000,-10.0000,0.0000,0.0000},
				{0.0200,29.1652,8.2500,39.6366,4.8000,-10.0000,-0.0000,39.6398,4.8000,-10.0000,0.0000,39.6366,4.8000,-10.0000,-0.0000,0.0000},
				{0.0200,29.2572,8.2500,39.7286,4.6000,-10.0000,0.0000,39.7318,4.6000,-10.0000,0.0000,39.7286,4.6000,-10.0000,0.0000,0.0000},
				{0.0200,29.3452,8.2500,39.8166,4.4000,-10.0000,0.0000,39.8198,4.4000,-10.0000,0.0000,39.8166,4.4000,-10.0000,0.0000,0.0000},
				{0.0200,29.4292,8.2500,39.9006,4.2000,-10.0000,-0.0000,39.9038,4.2000,-10.0000,0.0000,39.9006,4.2000,-10.0000,-0.0000,0.0000},
				{0.0200,29.5092,8.2500,39.9806,4.0000,-10.0000,0.0000,39.9838,4.0000,-10.0000,0.0000,39.9806,4.0000,-10.0000,0.0000,0.0000},
				{0.0200,29.5852,8.2500,40.0566,3.8000,-10.0000,0.0000,40.0598,3.8000,-10.0000,0.0000,40.0566,3.8000,-10.0000,0.0000,0.0000},
				{0.0200,29.6572,8.2500,40.1286,3.6000,-10.0000,0.0000,40.1318,3.6000,-10.0000,0.0000,40.1286,3.6000,-10.0000,0.0000,0.0000},
				{0.0200,29.7252,8.2500,40.1966,3.4000,-10.0000,-0.0000,40.1998,3.4000,-10.0000,0.0000,40.1966,3.4000,-10.0000,-0.0000,0.0000},
				{0.0200,29.7892,8.2500,40.2606,3.2000,-10.0000,0.0000,40.2638,3.2000,-10.0000,0.0000,40.2606,3.2000,-10.0000,0.0000,0.0000},
				{0.0200,29.8492,8.2500,40.3206,3.0000,-10.0000,-0.0000,40.3238,3.0000,-10.0000,0.0000,40.3206,3.0000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9052,8.2500,40.3766,2.8000,-10.0000,-0.0000,40.3798,2.8000,-10.0000,0.0000,40.3766,2.8000,-10.0000,-0.0000,0.0000},
				{0.0200,29.9572,8.2500,40.4286,2.6000,-10.0000,0.0000,40.4318,2.6000,-10.0000,0.0000,40.4286,2.6000,-10.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,2.1405,-22.9755,-648.7745,40.4746,2.4000,-10.0000,0.0000,40.4714,2.1405,-22.9755,-648.7745,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,-107.0245,-4202.4509,40.4746,2.2000,-10.0000,0.0000,40.4714,0.0000,-107.0245,-4202.4509,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,5351.2255,40.4746,2.0000,-10.0000,0.0000,40.4714,0.0000,0.0000,5351.2255,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,1.8000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,1.6000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,1.4000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,1.2000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,1.0000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,0.8000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,0.6000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,0.4000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,0.2000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},
				{0.0200,30.0000,8.2500,40.4714,0.0000,0.0000,0.0000,40.4746,-0.0000,-10.0000,0.0000,40.4714,0.0000,0.0000,0.0000,0.0000},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}