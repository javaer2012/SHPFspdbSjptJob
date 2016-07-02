package com.ideal.spdb.utils;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:排序算法
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author dinghui create date: 2011-12-12
 * @version 1.0
 */
public class SortArithmetic {
	/**
	 * 冒泡排序
	 * @param arr 要排序的数组
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 插入排序
	 * @param arr要排序的数组
	 */
	public static void insertSrot(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			int target = arr[i];
			while (j > 0 && target < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = target;
		}
	}
}
