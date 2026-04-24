#include<stdio.h>
#define size 100

int n, m;
int arr[100];
int idx;
int total;

int deque[size];

int front = 0, back = 1;
int temp_front, temp_back;

void left_move() {
    deque[back]=deque[(front+1+size)%size];
    back = (back+1) % size;
    front = (front + 1) % size;
    return;
}

void right_move() {
    deque[front] = deque[(back - 1 + size) % size];
    back = (back - 1+size) % size;
    front = (front -1+size) % size;
    return;
}

void pop_front() {
    front = (front + 1) % size;
    return;
}

int main(void) {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
        scanf("%d", &arr[i]);
    }

    for (int i = 1; i <= n; i++) {
        deque[i] = i;
    }
    back = n + 1;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < (back-front+size-1)%size; j++) {
            if (deque[(front+1+j)%size] == arr[i]) {
                idx = (front+1+j)%size;
                break;
            }
        }
        temp_front = front;
        temp_back = back;
        if (((idx - temp_front - 1+size)%size) > (temp_back - idx+size)%size) {
            for (int j = 0; j < ((temp_back - idx + size)%size); j++) {
                right_move();
                total++;
            }
            pop_front();
        }
        else {
            for (int j = 0; j < ((idx - temp_front - 1 + size) % size); j++) {
                left_move();
                total++;
            }
            pop_front();
        }
    }

    printf("%d\n", total);
}
