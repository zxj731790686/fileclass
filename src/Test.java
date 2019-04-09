import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * 计算A^5+B^5+C^5+D^5+E^5==F^5在[1,100]以内的所有正整数解 程序计算与优化典型题目
 * 
 * @author ZHAO Jing
 *         要点:(1)分析,测算程序复杂度,(2)利用空间换时间(3)循环强度削弱(二分查找)(4)一些编程细节:防止中间结果溢出
 *         ,用整数运算代替浮点幂计算
 */
public class Test {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// brute();// 估计时间为10^12/1517381580*smart()=126637. s=35.1768小时
		// smart();// 192.156s
		// smart2();//36.672s
		smart3();// 7.953s
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	/**
	 * 暴力法,速度太慢,10^12次循环体,不要执行这个函数 注意防止计算的中间结果溢出
	 */
	static void brute() {
		int answer = JOptionPane.showConfirmDialog(null,
				"这个程序估计要耗时35.2小时,确认执行么");
		if (answer == JOptionPane.CANCEL_OPTION) {
			return;
		}
		final int N = 100;
		int a, b, c, d, e, f;
		for (a = 1; a <= N; a++)
			for (b = 1; b <= N; b++)
				for (c = 1; c <= N; c++)
					for (d = 1; d <= N; d++)
						for (e = 1; e <= N; e++)
							for (f = 1; f <= N; f++) {
								if (1L * a * a * a * a * a + 1L * b * b * b * b
										* b + 1L * c * c * c * c * c + 1L * d
										* d * d * d * d + 1L * e * e * e * e
										* e == 1L * f * f * f * f * f)
									System.out.printf("%d %d %d %d %d %d \n", a, b,
											c, d, e, f);
							}
	}

	/**
	 * 分析改进法,可以假定A<=B<=C<=D<=E<F 则可以优化程序,大概执行1517381580次循环体(手动测试)
	 */
	static void smart() {
		final int N = 100;
		int a, b, c, d, e, f;
		// long cnt = 0L;
		for (a = 1; a < N; a++)
			for (b = a; b < N; b++)
				for (c = b; c < N; c++)
					for (d = c; d < N; d++)
						for (e = d; e < N; e++)
							for (f = e + 1; f <= N; f++) {
								if (1L * a * a * a * a * a + 1L * b * b * b * b
										* b + 1L * c * c * c * c * c + 1L * d
										* d * d * d * d + 1L * e * e * e * e
										* e == 1L * f * f * f * f * f)
									System.out.printf("%d %d %d %d %d %d \n", a, b,
											c, d, e, f);
								// cnt++;
							}
		// System.out.println(cnt);
	}

	/**
	 * 用空间换时间的方法,该程序的瓶颈主要在与六重循环, 所以目标是(1)优化循环体计算次数(用数组避免5次方计算) (2)减少循环强度
	 */
	static void smart2() {
		final int N = 100;
		long[] p = new long[N + 1];
		for (int i = 0; i < p.length; i++)
			p[i] = 1L * i * i * i * i * i;

		int a, b, c, d, e, f;
		for (a = 1; a < N; a++)
			for (b = a; b < N; b++)
				for (c = b; c < N; c++)
					for (d = c; d < N; d++)
						for (e = d; e < N; e++)
							for (f = e + 1; f <= N; f++)
								if (p[a] + p[b] + p[c] + p[d] + p[e] == p[f])
									System.out.printf("%d %d %d %d %d %d \n", a, b,
											c, d, e, f);
	}

	/**
	 * 目前最佳的程序代码之一, (2)利用二分查找代替一个循环,lgN和N的大小 希望有更好的程序 机器配置不太好,运行了7s
	 */
	static void smart3() {
		final int N = 100;
		long[] p = new long[N + 1];
		for (int i = 0; i < p.length; i++)
			p[i] = 1L * i * i * i * i * i;

		int a, b, c, d, e, f;
		long t;// 把临时变量定义在外面
		for (a = 1; a < N; a++)
			for (b = a; b < N; b++)
				for (c = b; c < N; c++)
					for (d = c; d < N; d++)
						for (e = d; e < N; e++) {
							t = p[a] + p[b] + p[c] + p[d] + p[e];
							// f = Arrays.binarySearch(p,t);//也可以但是稍逊与下面的调用形式
							f = Arrays.binarySearch(p, e + 1, N, t);// 二分查找提供了多种参数,这样指定二分查找的区间可以更快一些(因为区间更短)
							if (f >= 0)
								System.out.printf("%d %d %d %d %d %d \n", a, b,
										c, d, e, f);
						}
	}
}