import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * ����A^5+B^5+C^5+D^5+E^5==F^5��[1,100]���ڵ������������� ����������Ż�������Ŀ
 * 
 * @author ZHAO Jing
 *         Ҫ��:(1)����,��������Ӷ�,(2)���ÿռ任ʱ��(3)ѭ��ǿ������(���ֲ���)(4)һЩ���ϸ��:��ֹ�м������
 *         ,������������渡���ݼ���
 */
public class Test {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// brute();// ����ʱ��Ϊ10^12/1517381580*smart()=126637. s=35.1768Сʱ
		// smart();// 192.156s
		// smart2();//36.672s
		smart3();// 7.953s
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	/**
	 * ������,�ٶ�̫��,10^12��ѭ����,��Ҫִ��������� ע���ֹ������м������
	 */
	static void brute() {
		int answer = JOptionPane.showConfirmDialog(null,
				"����������Ҫ��ʱ35.2Сʱ,ȷ��ִ��ô");
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
	 * �����Ľ���,���Լٶ�A<=B<=C<=D<=E<F ������Ż�����,���ִ��1517381580��ѭ����(�ֶ�����)
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
	 * �ÿռ任ʱ��ķ���,�ó����ƿ����Ҫ��������ѭ��, ����Ŀ����(1)�Ż�ѭ����������(���������5�η�����) (2)����ѭ��ǿ��
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
	 * Ŀǰ��ѵĳ������֮һ, (2)���ö��ֲ��Ҵ���һ��ѭ��,lgN��N�Ĵ�С ϣ���и��õĳ��� �������ò�̫��,������7s
	 */
	static void smart3() {
		final int N = 100;
		long[] p = new long[N + 1];
		for (int i = 0; i < p.length; i++)
			p[i] = 1L * i * i * i * i * i;

		int a, b, c, d, e, f;
		long t;// ����ʱ��������������
		for (a = 1; a < N; a++)
			for (b = a; b < N; b++)
				for (c = b; c < N; c++)
					for (d = c; d < N; d++)
						for (e = d; e < N; e++) {
							t = p[a] + p[b] + p[c] + p[d] + p[e];
							// f = Arrays.binarySearch(p,t);//Ҳ���Ե�����ѷ������ĵ�����ʽ
							f = Arrays.binarySearch(p, e + 1, N, t);// ���ֲ����ṩ�˶��ֲ���,����ָ�����ֲ��ҵ�������Ը���һЩ(��Ϊ�������)
							if (f >= 0)
								System.out.printf("%d %d %d %d %d %d \n", a, b,
										c, d, e, f);
						}
	}
}