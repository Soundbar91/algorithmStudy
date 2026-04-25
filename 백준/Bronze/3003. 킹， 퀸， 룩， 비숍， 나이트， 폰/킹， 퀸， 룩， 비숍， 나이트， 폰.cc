#include <stdio.h>

int main() {

	int num1, num2, num3, num4, num5, num6 = 0;

	scanf("%d %d %d %d %d %d", &num1, &num2, &num3, &num4, &num5, &num6);
	printf("%d %d %d %d %d %d", 1 - num1, 1 - num2, 2 - num3, 2 - num4, 2 - num5, 8 - num6);

	return 0;
}