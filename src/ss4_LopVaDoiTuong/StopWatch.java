package ss4_LopVaDoiTuong;

import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }
    public static void main(String[] args){
        int size = 100000;
        int[] arr = new int[size];
        Random random = new Random();

        System.out.println("Đang tạo mảng với " + size + " số ngẫu nhiên..");
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(100000);
        }

        StopWatch stopWatch = new StopWatch();
        System.out.println("Bắt đầu sắp xếp... Vui lòng đơi");
        stopWatch.start();
        selectionSort(arr);

        stopWatch.stop();

        System.out.println("Đã sắp xếp xong!");
        System.out.println("Thời gian thực thi: " + stopWatch.getElapsedTime() + " milliseconds");
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
