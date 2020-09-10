package com.chen.library.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class NumberUtils {
	/** 常量--0 */
	public static final int ZERO = 0;
	/** 常量--1 */
	public static final int ONE = 1;
	/** 常量-- -1 */
	public static final int MINUS_ONE = -1;
	/**
	 * 计算百分比 整数
	 *
	 * @param divisor
	 * @param dividend
	 * @return
	 */
	public static String proportionInt(Integer divisor, Integer dividend) {
		if (dividend == null || divisor == null)
			return null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) divisor / (float) dividend * 100);
		if (result.indexOf(".") != -1) {
			result = Math.round(Double.parseDouble(result)) + "%";
		}
		return result;
	}

	/**
	 * 计算百分比 整数
	 *
	 * @param divisor
	 * @param dividend
	 * @return
	 */
	public static String proportionInt(Float divisor, Float dividend) {
		if (dividend == null || divisor == null)
			return null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format(divisor / dividend * 100);
		if (result.indexOf(".") != -1) {
			result = Math.round(Double.parseDouble(result)) + "%";
		}
		return result;
	}

	/**
	 * 计算百分比 保留留n位小数
	 * 包含百分号
	 * @param divisor
	 * @param dividend
	 * @param bit
	 * @return
	 */
	public static String proportionDouble(Integer divisor, Integer dividend, Integer bit) {
		if (dividend == null || divisor == null || bit == null)
			return null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(bit);
		String result = numberFormat.format((float) divisor / (float) dividend * 100);

		return result + "%";
	}
	/**
	 * 计算百分比 保留留n位小数
	 * 不含百分号
	 * @param divisor
	 * @param dividend
	 * @param bit
	 * @return
	 */
	public static String proportionString(Integer divisor, Integer dividend, Integer bit) {
		if (dividend == null || divisor == null || bit == null)
			return null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(bit);
		String result = numberFormat.format((float) divisor / (float) dividend * 100);

		return result;
	}
	/**
	 * 计算百分比 保留留n位小数
	 *
	 * @param divisor
	 * @param dividend
	 * @param bit
	 * @return
	 */
	public static String proportionDouble(Float divisor, Float dividend, Integer bit) {
		if (dividend == null || divisor == null || bit == null)
			return null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(bit);
		String result = numberFormat.format(divisor / dividend * 100);

		return result + "%";
	}

	/**
	 * 保留n为小数
	 *
	 * @param d
	 * @param bit
	 * @return
	 */
	public static Double doubleBit(Double d, Integer bit) {
		if (d == null || bit == null)
			return null;
		BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.DOWN);
		return bg.doubleValue();
	}

	/**
	 * 保留n位小数,小数不足补0
	 *
	 * @param d
	 * @param bit
	 * @return
	 */
	public static Double doubleBitWhole(Double d, Integer bit) {
		if (d == null || bit == null)
			return null;
		BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.DOWN);
		String dobu = bg.doubleValue() + "";
		if (dobu.indexOf(".") != -1) {
			String small = dobu.split("\\.")[1];
			for (int i = 0; i < bit - small.length(); i++) {
				dobu += "0";
			}

		}
		return Double.parseDouble(dobu);
	}

	/**
	 * 大小比较
	 *
	 * @param a
	 * @param b
	 * @return 返回1， 表示a大于b <br/>
	 *         返回0 ，表示a等于b <br/>
	 *         返回-1，表示a小于b
	 * @author jqlin
	 */
	public static int compareTo(String a, String b) {
		return new BigDecimal(a).compareTo(new BigDecimal(b));
	}

	/**
	 * 加法运算
	 *
	 * @param a 被加数
	 * @param b 加数
	 * @author jqlin
	 */
	public static BigDecimal add(String a, String b) {
		MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
		return new BigDecimal(a).add(new BigDecimal(b), mc);
	}

	/**
	 * 累加运算
	 *
	 * @param vals
	 * @return
	 * @author jqlin
	 */
	public static int add(int... vals) {
		if (vals == null || vals.length <= 0) {
			return 0;
		}

		int sum = 0;
		for (int val : vals) {
			sum = sum + val;
		}

		return sum;
	}

	/**
	 * 累加运算
	 *
	 * @param vals
	 * @return
	 * @author jqlin
	 */
	public static long add(long... vals) {
		if (vals == null || vals.length <= 0) {
			return 0L;
		}

		long sum = 0L;
		for (long val : vals) {
			sum = sum + val;
		}

		return sum;
	}

	/**
	 * 减法运算
	 *
	 * @param a 被减数
	 * @param b 减数
	 * @author jqlin
	 */
	public static BigDecimal subtract(String a, String b) {
		MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
		return new BigDecimal(a).subtract(new BigDecimal(b), mc);
	}

	/**
	 * 乘法运算
	 *
	 * @param a 被乘数
	 * @param b 乘数
	 * @author jqlin
	 */
	public static BigDecimal multiply(String a, String b) {
		MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
		return new BigDecimal(a).multiply(new BigDecimal(b), mc);
	}

	/**
	 * 除法运算
	 *
	 * @param a 被除数
	 * @param b 除数
	 * @author jqlin
	 */
	public static BigDecimal divide(String a, String b) {
		return new BigDecimal(a).divide(new BigDecimal(b), 20, BigDecimal.ROUND_HALF_UP);
	}

	public static void main(String[] args) {
		System.err.println(proportionString(345,654,2));
	}

}
