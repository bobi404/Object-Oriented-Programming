#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct User {
    char name[50];
    char pass[50];
    char phone[20];
};

struct User *users = NULL;
int count = 0;

void inputData();
void showData();
void deleteData();

int main() {
    int choice;
    do {
        printf("\n1. Input Data\n");
        printf("2. Show Data\n");
        printf("3. Delete Data\n");
        printf("4. Exit\n");
        printf("Your choice: ");
        scanf("%d", &choice);
        getchar();

        switch (choice) {
            case 1: inputData(); break;
            case 2: showData(); break;
            case 3: deleteData(); break;
            case 4: printf("Exiting...\n"); break;
            default: printf("Invalid choice!\n");
        }
    } while (choice != 4);

    free(users);
    return 0;
}

void inputData() {
    users = realloc(users, (count + 1) * sizeof(struct User));
    if (!users) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    printf("Name : ");
    fgets(users[count].name, sizeof(users[count].name), stdin);
    users[count].name[strcspn(users[count].name, "\n")] = 0;

    printf("Pass : ");
    fgets(users[count].pass, sizeof(users[count].pass), stdin);
    users[count].pass[strcspn(users[count].pass, "\n")] = 0;

    printf("Phone : ");
    fgets(users[count].phone, sizeof(users[count].phone), stdin);
    users[count].phone[strcspn(users[count].phone, "\n")] = 0;

    count++;
    printf("New data is added\n");
}

void showData() {
    if (count == 0) {
        printf("No data exists!\n");
        return;
    }
    printf("%-5s %-15s %-15s %-15s\n", "No", "Name", "Pass", "Phone");
    for (int i = 0; i < count; i++) {
        printf("%-5d %-15s %-15s %-15s\n", i+1, users[i].name, users[i].pass, users[i].phone);
    }
}

void deleteData() {
    if (count == 0) {
        printf("No data to delete!\n");
        return;
    }
    showData();
    int del;
    printf("Input data number to be deleted: ");
    scanf("%d", &del);
    getchar();

    if (del < 1 || del > count) {
        printf("Invalid number!\n");
        return;
    }

    for (int i = del-1; i < count-1; i++) {
        users[i] = users[i+1];
    }
    count--;

    users = realloc(users, count * sizeof(struct User));
    printf("Data is removed\n");
}
