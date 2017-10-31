/* MD5 without dividing the message into blocks */
class temp1
{	static long left_circular_shift(long x,long y)
	{	long i,temp1;
		for(i=0;i<y;i++)
		{	temp1=x&0x7fffffffl;
			temp1=temp1<<1;
			if((x&0x80000000l)>0)
				temp1++;
			x=temp1;
		}
		return(x);
	}		
	static long F(long X,long Y,long Z)
	{	return((X&Y)|((~X)&Z));
	}
	static long G(long X,long Y,long Z)
	{	return((X&Z)|(Y&(~Z)));
	}
	static long H(long X,long Y,long Z)
	{	return(X^(Y^Z));
	}
	static long I(long X,long Y,long Z)
	{	return(Y^(X|(~Z)));
	}
	static long FF(long a,long b,long c,long d,long M,long s,long t)
	{	return(b^left_circular_shift(a^F(b,c,d)^M^t,s));
	}
	static long GG(long a,long b,long c,long d,long M,long s,long t)
	{	return(b^left_circular_shift(a^G(b,c,d)^M^t,s));
	}
	static long HH(long a,long b,long c,long d,long M,long s,long t)
	{	return(b^left_circular_shift(a^H(b,c,d)^M^t,s));
	}
	static long II(long a,long b,long c,long d,long M,long s,long t)
	{	return(b^left_circular_shift(a^I(b,c,d)^M^t,s));
	}
	public static void main(String args[])
	{	int i,j,no_of_blocks=3,
			m[]={0xffffffff,0xfffffffe,0xfffffffd,0xfffffffc,
			0xfffffffb,0xfffffffa,0xfffffff9,0xfffffff8,
			0xfffffff7,0xfffffff6,0xfffffff5,0xfffffff4,
			0xfffffff3,0xfffffff2,0xfffffff1,0xfffffff0,
			
			0xfff1ffff,0xfff1fffe,0xfff1fffd,0xfff1fffc,
			0xfff1fffb,0xfff1fffa,0xfff1fff9,0xfff1fff8,
			0xfff1fff7,0xfff1fff6,0xfff1fff5,0xfff1fff4,
			0xfff1fff3,0xfff1fff2,0xfff1fff1,0xfff1fff0,
			
			0xfff2ffff,0xfff2fffe,0xfff2fffd,0xfff2fffc,
			0xfff2fffb,0xfff2fffa,0xfff2fff9,0xfff2fff8,
			0xfff2fff7,0xfff2fff6,0xfff2fff5,0xfff2fff4,
			0xfff2fff3,0xfff2fff2,0xfff2fff1,0xfff2fff0};
		long M[]=new long[16];
		long a,b,c,d,A=0x01234567l,B=0x89abcdefl,C=0xfedcba98l,D=0x76543210l;
		for(j=0;j<no_of_blocks;j++)
		{	for(i=0;i<16;i++)
				M[i]=(0x00000000ffffffffl)&m[(j*16)+i];
			a=A;
			b=B;
			c=C;
			d=D;
			/*round1*/
			a=FF(a,b,c,d,M[0],7,0xd76aa478l);
			d=FF(d,a,b,c,M[1],12,0xe8c7b756l);
			c=FF(c,d,a,b,M[2],17,0x242070dbl);
			b=FF(b,c,d,a,M[3],22,0xc1bdceeel);
			a=FF(a,b,c,d,M[4],7,0xf57c0fafl);
			d=FF(d,a,b,c,M[5],12,0x4787c62al);
			c=FF(c,d,a,b,M[6],17,0xa8304613l);
			b=FF(b,c,d,a,M[7],22,0xfd469501l);
			a=FF(a,b,c,d,M[8],7,0x698098d8l);
			d=FF(d,a,b,c,M[9],12,0x8b44f7afl);
			c=FF(c,d,a,b,M[10],17,0xffff5bb1l);
			b=FF(b,c,d,a,M[11],22,0x895cd7bel);
			a=FF(a,b,c,d,M[12],7,0x6b901122l);
			d=FF(d,a,b,c,M[13],12,0xfd987193l);
			c=FF(c,d,a,b,M[14],17,0xa679438el);
			b=FF(b,c,d,a,M[15],22,0x49b40821l);
			/*round2*/
			a=GG(a,b,c,d,M[1],9,0xf61e2562l);
			d=GG(d,a,b,c,M[6],9,0xc040b340l);
			c=GG(c,d,a,b,M[11],14,0x265e5a51l);
			b=GG(b,c,d,a,M[0],20,0xe9b6c7aal);
			a=GG(a,b,c,d,M[5],5,0xd62f105dl);
			d=GG(d,a,b,c,M[10],9,0x02441453l);
			c=GG(c,d,a,b,M[15],14,0xd8a1e681l);
			b=GG(b,c,d,a,M[4],20,0xe7d3fbc8l);
			a=GG(a,b,c,d,M[9],5,0x21e1cde6l);
			d=GG(d,a,b,c,M[14],9,0xc33707d6l);
			c=GG(c,d,a,b,M[3],14,0xf4d50d87l);
			b=GG(b,c,d,a,M[8],20,0x455a14edl);
			a=GG(a,b,c,d,M[13],5,0xa9e3e905l);
			d=GG(d,a,b,c,M[2],9,0xfcefa3f8l);
			c=GG(c,d,a,b,M[7],14,0x676f02d9l);
			b=GG(b,c,d,a,M[12],20,0x8d2a4c8al);
			/*round3*/
			a=HH(a,b,c,d,M[5],4,0xfffa3942l);
			d=HH(d,a,b,c,M[8],11,0x8771f681l);
			c=HH(c,d,a,b,M[11],16,0x6d9d6122l);
			b=HH(b,c,d,a,M[14],23,0xfde5380cl);
			a=HH(a,b,c,d,M[1],4,0xa4beea44l);
			d=HH(d,a,b,c,M[4],11,0x4bdecfa9l);
			c=HH(c,d,a,b,M[7],16,0xf6bb4b60l);
			b=HH(b,c,d,a,M[10],23,0xbebfbc70l);
			a=HH(a,b,c,d,M[13],4,0x289b7ec6l);
			d=HH(d,a,b,c,M[0],11,0xeaa127fal);
			c=HH(c,d,a,b,M[3],16,0xd4ef3085l);
			b=HH(b,c,d,a,M[6],23,0x04881d05l);
			a=HH(a,b,c,d,M[9],4,0xd9d4d039l);
			d=HH(d,a,b,c,M[12],11,0xe6db99e5l);
			c=HH(c,d,a,b,M[15],16,0x1fa27cf8l);
			b=HH(b,c,d,a,M[2],23,0xc4ac5665l);
			/*round4*/
			a=HH(a,b,c,d,M[0],6,0xf4292244l);
			d=HH(d,a,b,c,M[7],10,0x432aff97l);
			c=HH(c,d,a,b,M[14],15,0xab9423a7l);
			b=HH(b,c,d,a,M[5],21,0xfc93a039l);
			a=HH(a,b,c,d,M[12],6,0x655b59c3l);
			d=HH(d,a,b,c,M[3],10,0x8f0ccc92l);
			c=HH(c,d,a,b,M[10],15,0xffeff47dl);
			b=HH(b,c,d,a,M[1],21,0x85845dd1l);
			a=HH(a,b,c,d,M[8],6,0x6fa87e4fl);
			d=HH(d,a,b,c,M[15],10,0xfe2ce6e0l);
			c=HH(c,d,a,b,M[6],15,0xa3014314l);
			b=HH(b,c,d,a,M[13],21,0x4e0811a1l);
			a=HH(a,b,c,d,M[4],6,0xf7537e82l);
			d=HH(d,a,b,c,M[11],10,0xbd3af235l);
			c=HH(c,d,a,b,M[2],15,0x2ad7d2bbl);
			b=HH(b,c,d,a,M[9],21,0xeb86d391l);
		
			A=A^a;
			B=B^b;
			C=C^c;
			D=D^d;
		}
			System.out.println(A+" "+B+" "+C+" "+D);
	}
}
