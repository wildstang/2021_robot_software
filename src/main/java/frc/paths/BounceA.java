package frc.paths;

import com.team319.trajectory.Path;

public class BounceA extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,3.7540,7.5000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0040,0.2000,10.0000,0.0000,0.0000},
				{0.0200,3.7620,7.5000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0120,0.4000,10.0000,0.0000,0.0000},
				{0.0200,3.7740,7.5000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,0.0000,0.0240,0.6000,10.0000,0.0000,0.0000},
				{0.0200,3.7900,7.5000,0.0400,0.8000,10.0000,-0.0000,0.0400,0.8000,10.0000,0.0000,0.0400,0.8000,10.0000,-0.0000,0.0001},
				{0.0200,3.8100,7.5000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,0.0000,0.0600,1.0000,10.0000,0.0000,0.0002},
				{0.0200,3.8340,7.5000,0.0840,1.2000,10.0000,-0.0000,0.0840,1.2000,10.0000,0.0000,0.0840,1.2000,10.0000,-0.0000,0.0004},
				{0.0200,3.8620,7.5000,0.1120,1.4000,10.0000,-0.0000,0.1120,1.4000,10.0000,0.0000,0.1120,1.4000,10.0000,-0.0000,0.0006},
				{0.0200,3.8940,7.5000,0.1440,1.6000,10.0000,-0.0000,0.1440,1.6000,10.0000,0.0000,0.1440,1.6000,10.0000,-0.0000,0.0010},
				{0.0200,3.9300,7.5001,0.1800,1.8000,10.0000,-0.0000,0.1800,1.8000,10.0000,0.0000,0.1800,1.8000,10.0000,-0.0000,0.0016},
				{0.0200,3.9700,7.5002,0.2200,2.0000,10.0000,-0.0000,0.2200,2.0000,10.0000,0.0000,0.2200,2.0000,10.0000,-0.0000,0.0024},
				{0.0200,4.0140,7.5003,0.2640,2.2000,10.0000,-0.0001,0.2640,2.2000,10.0000,0.0000,0.2640,2.2000,10.0000,-0.0001,0.0034},
				{0.0200,4.0620,7.5005,0.3120,2.4000,10.0000,-0.0001,0.3120,2.4000,10.0000,0.0000,0.3120,2.4000,10.0000,-0.0001,0.0048},
				{0.0200,4.1140,7.5008,0.3640,2.6000,10.0000,-0.0001,0.3640,2.6000,10.0000,0.0000,0.3640,2.6000,10.0000,-0.0001,0.0065},
				{0.0200,4.1700,7.5012,0.4200,2.8000,10.0000,-0.0002,0.4200,2.8000,10.0000,0.0000,0.4200,2.8000,10.0000,-0.0002,0.0086},
				{0.0200,4.2300,7.5018,0.4800,3.0000,10.0000,-0.0003,0.4800,3.0000,10.0000,0.0000,0.4800,3.0000,10.0000,-0.0003,0.0112},
				{0.0200,4.2940,7.5026,0.5440,3.2000,10.0000,-0.0004,0.5440,3.2000,10.0000,0.0000,0.5440,3.2000,10.0000,-0.0004,0.0144},
				{0.0200,4.3620,7.5037,0.6120,3.4000,10.0000,-0.0006,0.6120,3.4000,10.0000,0.0000,0.6120,3.4000,10.0000,-0.0006,0.0181},
				{0.0200,4.4340,7.5052,0.6840,3.6000,9.9999,-0.0008,0.6840,3.6000,10.0000,0.0000,0.6840,3.6000,9.9999,-0.0008,0.0226},
				{0.0200,4.5099,7.5071,0.7600,3.8000,9.9999,-0.0010,0.7600,3.8000,10.0000,0.0000,0.7600,3.8000,9.9999,-0.0010,0.0279},
				{0.0200,4.5899,7.5096,0.8400,4.0000,9.9999,-0.0014,0.8400,4.0000,10.0000,0.0000,0.8400,4.0000,9.9999,-0.0014,0.0342},
				{0.0200,4.6738,7.5128,0.9240,4.2000,9.9999,-0.0019,0.9240,4.2000,10.0000,0.0000,0.9240,4.2000,9.9999,-0.0019,0.0414},
				{0.0200,4.7618,7.5168,1.0120,4.4000,9.9998,-0.0026,1.0120,4.4000,10.0000,0.0000,1.0120,4.4000,9.9998,-0.0026,0.0499},
				{0.0200,4.8536,7.5218,1.1040,4.6000,9.9997,-0.0036,1.1040,4.6000,10.0000,0.0000,1.1040,4.6000,9.9997,-0.0036,0.0596},
				{0.0200,4.9494,7.5280,1.2000,4.8000,9.9996,-0.0049,1.2000,4.8000,10.0000,0.0000,1.2000,4.8000,9.9996,-0.0049,0.0709},
				{0.0200,5.0491,7.5358,1.3000,5.0000,9.9995,-0.0067,1.3000,5.0000,10.0000,0.0000,1.3000,5.0000,9.9995,-0.0067,0.0840},
				{0.0200,5.1527,7.5453,1.4040,5.2000,9.9993,-0.0092,1.4040,5.2000,10.0000,0.0000,1.4040,5.2000,9.9993,-0.0092,0.0990},
				{0.0200,5.2600,7.5569,1.5120,5.3999,9.9991,-0.0127,1.5120,5.4000,10.0000,0.0000,1.5120,5.3999,9.9991,-0.0127,0.1164},
				{0.0200,5.3712,7.5710,1.6240,5.5999,9.9987,-0.0177,1.6240,5.6000,10.0000,0.0000,1.6240,5.5999,9.9987,-0.0177,0.1364},
				{0.0200,5.4859,7.5880,1.7400,5.7999,9.9982,-0.0246,1.7400,5.8000,10.0000,0.0000,1.7400,5.7999,9.9982,-0.0246,0.1595},
				{0.0200,5.6041,7.6086,1.8600,5.9998,9.9975,-0.0345,1.8600,6.0000,10.0000,0.0000,1.8600,5.9998,9.9975,-0.0345,0.1862},
				{0.0200,5.7256,7.6334,1.9840,6.1998,9.9966,-0.0483,1.9840,6.2000,10.0000,0.0000,1.9840,6.1998,9.9966,-0.0483,0.2171},
				{0.0200,5.8501,7.6632,2.1120,6.3997,9.9952,-0.0677,2.1120,6.4000,10.0000,0.0000,2.1120,6.3997,9.9952,-0.0677,0.2530},
				{0.0200,5.9772,7.6988,2.2440,6.5995,9.9933,-0.0940,2.2440,6.6000,10.0000,0.0000,2.2440,6.5995,9.9933,-0.0940,0.2946},
				{0.0200,6.1063,7.7414,2.3800,6.7993,9.9908,-0.1279,2.3800,6.8000,10.0000,0.0000,2.3800,6.7993,9.9908,-0.1279,0.3429},
				{0.0200,6.2368,7.7921,2.5199,6.9991,9.9874,-0.1680,2.5200,7.0000,10.0000,0.0000,2.5199,6.9991,9.9874,-0.1680,0.3988},
				{0.0200,6.3677,7.8521,2.6639,7.1988,9.9833,-0.2062,2.6640,7.2000,10.0000,0.0000,2.6639,7.1988,9.9833,-0.2062,0.4633},
				{0.0200,6.4975,7.9230,2.8119,7.3983,9.9788,-0.2234,2.8120,7.4000,10.0000,0.0000,2.8119,7.3983,9.9788,-0.2234,0.5369},
				{0.0200,6.6248,8.0060,2.9638,7.5978,9.9751,-0.1854,2.9640,7.6000,10.0000,0.0000,2.9638,7.5978,9.9751,-0.1854,0.6196},
				{0.0200,6.7476,8.1022,3.1198,7.7973,9.9741,-0.0516,3.1200,7.8000,10.0000,0.0000,3.1198,7.7973,9.9741,-0.0516,0.7105},
				{0.0200,6.8637,8.2122,3.2797,7.9969,9.9779,0.1906,3.2800,8.0000,10.0000,0.0000,3.2797,7.9969,9.9779,0.1906,0.8073},
				{0.0200,6.9710,8.3361,3.4436,8.1966,9.9874,0.4774,3.4440,8.2000,10.0000,0.0000,3.4436,8.1966,9.9874,0.4774,0.9067},
				{0.0200,7.0678,8.4733,3.6116,8.3966,10.0008,0.6693,3.6120,8.4000,10.0000,0.0000,3.6116,8.3966,10.0008,0.6693,1.0046},
				{0.0200,7.1531,8.6226,3.7835,8.5969,10.0138,0.6503,3.7840,8.6000,10.0000,0.0000,3.7835,8.5969,10.0138,0.6503,1.0974},
				{0.0200,7.2265,8.7825,3.9595,8.7974,10.0226,0.4378,3.9600,8.8000,10.0000,0.0000,3.9595,8.7974,10.0226,0.4378,1.1821},
				{0.0200,7.2857,8.9440,4.1314,8.5981,-9.9613,-999.1953,4.1320,8.6000,-10.0000,0.0000,4.1314,8.5981,-9.9613,-999.1953,1.2542},
				{0.0200,7.3331,9.1051,4.2994,8.3987,-9.9707,-0.4685,4.3000,8.4000,-10.0000,0.0000,4.2994,8.3987,-9.9707,-0.4685,1.3145},
				{0.0200,7.3705,9.2648,4.4634,8.1991,-9.9791,-0.4221,4.4640,8.2000,-10.0000,0.0000,4.4634,8.1991,-9.9791,-0.4221,1.3646},
				{0.0200,7.3999,9.4220,4.6234,7.9994,-9.9857,-0.3262,4.6240,8.0000,-10.0000,0.0000,4.6234,7.9994,-9.9857,-0.3262,1.4060},
				{0.0200,7.4228,9.5763,4.7794,7.7996,-9.9903,-0.2333,4.7800,7.8000,-10.0000,0.0000,4.7794,7.7996,-9.9903,-0.2333,1.4400},
				{0.0200,7.4405,9.7273,4.9314,7.5998,-9.9935,-0.1604,4.9320,7.6000,-10.0000,0.0000,4.9314,7.5998,-9.9935,-0.1604,1.4680},
				{0.0200,7.4540,9.8747,5.0794,7.3998,-9.9957,-0.1083,5.0800,7.4000,-10.0000,0.0000,5.0794,7.3998,-9.9957,-0.1083,1.4908},
				{0.0200,7.4641,10.0183,5.2234,7.1999,-9.9971,-0.0725,5.2240,7.2000,-10.0000,0.0000,5.2234,7.1999,-9.9971,-0.0725,1.5094},
				{0.0200,7.4716,10.1581,5.3634,6.9999,-9.9981,-0.0485,5.3640,7.0000,-10.0000,0.0000,5.3634,6.9999,-9.9981,-0.0485,1.5244},
				{0.0200,7.4771,10.2940,5.4994,6.8000,-9.9988,-0.0324,5.5000,6.8000,-10.0000,0.0000,5.4994,6.8000,-9.9988,-0.0324,1.5365},
				{0.0200,7.4809,10.4260,5.6314,6.6000,-9.9992,-0.0217,5.6320,6.6000,-10.0000,0.0000,5.6314,6.6000,-9.9992,-0.0217,1.5460},
				{0.0200,7.4836,10.5539,5.7594,6.4000,-9.9995,-0.0145,5.7600,6.4000,-10.0000,0.0000,5.7594,6.4000,-9.9995,-0.0145,1.5534},
				{0.0200,7.4854,10.6779,5.8834,6.2000,-9.9997,-0.0097,5.8840,6.2000,-10.0000,0.0000,5.8834,6.2000,-9.9997,-0.0097,1.5590},
				{0.0200,7.4866,10.7979,6.0034,6.0000,-9.9998,-0.0064,6.0040,6.0000,-10.0000,0.0000,6.0034,6.0000,-9.9998,-0.0064,1.5632},
				{0.0200,7.4873,10.9139,6.1194,5.8000,-9.9999,-0.0041,6.1200,5.8000,-10.0000,0.0000,6.1194,5.8000,-9.9999,-0.0041,1.5660},
				{0.0200,7.4877,11.0259,6.2314,5.6000,-9.9999,-0.0026,6.2320,5.6000,-10.0000,0.0000,6.2314,5.6000,-9.9999,-0.0026,1.5679},
				{0.0200,7.4879,11.1339,6.3394,5.4000,-10.0000,-0.0016,6.3400,5.4000,-10.0000,0.0000,6.3394,5.4000,-10.0000,-0.0016,1.5688},
				{0.0200,7.4881,11.2379,6.4434,5.2000,-10.0000,-0.0009,6.4440,5.2000,-10.0000,0.0000,6.4434,5.2000,-10.0000,-0.0009,1.5691},
				{0.0200,7.4883,11.3379,6.5434,5.0000,-10.0000,-0.0005,6.5440,5.0000,-10.0000,0.0000,6.5434,5.0000,-10.0000,-0.0005,1.5688},
				{0.0200,7.4885,11.4339,6.6394,4.8000,-10.0000,-0.0002,6.6400,4.8000,-10.0000,0.0000,6.6394,4.8000,-10.0000,-0.0002,1.5682},
				{0.0200,7.4888,11.5259,6.7314,4.6000,-10.0000,-0.0000,6.7320,4.6000,-10.0000,0.0000,6.7314,4.6000,-10.0000,-0.0000,1.5672},
				{0.0200,7.4892,11.6139,6.8194,4.4000,-10.0000,0.0000,6.8200,4.4000,-10.0000,0.0000,6.8194,4.4000,-10.0000,0.0000,1.5660},
				{0.0200,7.4896,11.6979,6.9034,4.2000,-10.0000,0.0001,6.9040,4.2000,-10.0000,0.0000,6.9034,4.2000,-10.0000,0.0001,1.5646},
				{0.0200,7.4902,11.7779,6.9834,4.0000,-10.0000,0.0001,6.9840,4.0000,-10.0000,0.0000,6.9834,4.0000,-10.0000,0.0001,1.5632},
				{0.0200,7.4908,11.8539,7.0594,3.8000,-10.0000,0.0001,7.0600,3.8000,-10.0000,0.0000,7.0594,3.8000,-10.0000,0.0001,1.5618},
				{0.0200,7.4915,11.9259,7.1314,3.6000,-10.0000,0.0001,7.1320,3.6000,-10.0000,0.0000,7.1314,3.6000,-10.0000,0.0001,1.5605},
				{0.0200,7.4923,11.9939,7.1994,3.4000,-10.0000,0.0000,7.2000,3.4000,-10.0000,0.0000,7.1994,3.4000,-10.0000,0.0000,1.5592},
				{0.0200,7.4930,12.0579,7.2634,3.2000,-10.0000,0.0000,7.2640,3.2000,-10.0000,0.0000,7.2634,3.2000,-10.0000,0.0000,1.5581},
				{0.0200,7.4938,12.1179,7.3234,3.0000,-10.0000,-0.0000,7.3240,3.0000,-10.0000,0.0000,7.3234,3.0000,-10.0000,-0.0000,1.5570},
				{0.0200,7.4946,12.1739,7.3794,2.8000,-10.0000,-0.0000,7.3800,2.8000,-10.0000,0.0000,7.3794,2.8000,-10.0000,-0.0000,1.5562},
				{0.0200,7.4954,12.2259,7.4314,2.6000,-10.0000,-0.0000,7.4320,2.6000,-10.0000,0.0000,7.4314,2.6000,-10.0000,-0.0000,1.5554},
				{0.0200,7.4962,12.2739,7.4794,2.4000,-10.0000,-0.0000,7.4800,2.4000,-10.0000,0.0000,7.4794,2.4000,-10.0000,-0.0000,1.5548},
				{0.0200,7.4969,12.3179,7.5234,2.2000,-10.0000,-0.0000,7.5240,2.2000,-10.0000,0.0000,7.5234,2.2000,-10.0000,-0.0000,1.5543},
				{0.0200,7.4975,12.3579,7.5634,2.0000,-10.0000,-0.0000,7.5640,2.0000,-10.0000,0.0000,7.5634,2.0000,-10.0000,-0.0000,1.5540},
				{0.0200,7.4982,12.3939,7.5994,1.8000,-10.0000,-0.0000,7.6000,1.8000,-10.0000,0.0000,7.5994,1.8000,-10.0000,-0.0000,1.5537},
				{0.0200,7.4987,12.4259,7.6314,1.6000,-10.0000,-0.0000,7.6320,1.6000,-10.0000,0.0000,7.6314,1.6000,-10.0000,-0.0000,1.5535},
				{0.0200,7.4992,12.4538,7.6594,1.4000,-10.0000,-0.0000,7.6600,1.4000,-10.0000,0.0000,7.6594,1.4000,-10.0000,-0.0000,1.5534},
				{0.0200,7.4996,12.4778,7.6834,1.2000,-10.0000,-0.0000,7.6840,1.2000,-10.0000,0.0000,7.6834,1.2000,-10.0000,-0.0000,1.5534},
				{0.0200,7.5000,12.4978,7.7034,1.0000,-10.0000,-0.0000,7.7040,1.0000,-10.0000,0.0000,7.7034,1.0000,-10.0000,-0.0000,1.5533},
				{0.0200,7.5000,12.5000,7.7055,0.1079,-44.6052,-1730.2617,7.7062,0.8000,-10.0000,0.0000,7.7055,0.1079,-44.6052,-1730.2617,1.5533},
				{0.0200,7.5000,12.5000,7.7055,0.0000,-5.3948,1960.5235,7.7062,0.6000,-10.0000,0.0000,7.7055,0.0000,-5.3948,1960.5235,1.5533},
				{0.0200,7.5000,12.5000,7.7055,0.0000,0.0000,269.7383,7.7062,0.4000,-10.0000,0.0000,7.7055,0.0000,0.0000,269.7383,1.5533},
				{0.0200,7.5000,12.5000,7.7055,0.0000,0.0000,0.0000,7.7062,0.2000,-10.0000,0.0000,7.7055,0.0000,0.0000,0.0000,1.5533},
				{0.0200,7.5000,12.5000,7.7055,0.0000,0.0000,0.0000,7.7062,-0.0000,-10.0000,0.0000,7.7055,0.0000,0.0000,0.0000,1.5533},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}