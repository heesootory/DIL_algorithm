#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <iostream>

void print_day(int a) {
	switch (a % 7) {
	case 1:
		printf("MON"); break;
	case 2:
		printf("TUE"); break;
	case 3:
		printf("WED"); break;
	case 4:
		printf("THU"); break;
	case 5:
		printf("FRI"); break;
	case 6:
		printf("SAT"); break;
	default:
		printf("SUN"); break;
	}
}
int main() {

	int x, y;
	scanf("%d %d", &x, &y);

	int arr[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	int day = 0;	

	if (x == 0) {
		day += y;
		print_day(day);
	}
	else {
		for (int i = 0; i < x - 1; i++) {
			day += arr[i];
		}
		day += y;
		print_day(day);
	}
	

	return 0;
}