#include<stdlib.h> 
#include<stdio.h>

//用链表建立一个班级同学录，同学录的信息包括学生姓名、班级、专业、手机号码、 QQ 号码、邮箱等。功能要求：
//（1） 新建同学录 Creat()；
//（2） 在界面上打印所有学生信息 Print(struct Student *)
//（3） 打印指定学生的信息 Print(struct Student *, int id)
//（4） 插入新加入学生信息 Insert()
//（5） 删除指定学生信息 Delete();

struct Student {
	int id;
	char name[20]; 
	//char class[20];	char major[20];	char phoneNumber[20]; char qqNumber[20]; char email[20];
	struct Student * next;
};

struct Student * Creat() {
	struct Student * book;
	book = NULL;
	return book;
}
void Print(struct Student * book) {
	if (book == NULL) {
		printf("the address list is empty!");
		return;
	}
	else {
		while (book->next != NULL)
		{
			printf("%d %s\n", book->id, book->name);
			book = book->next;
		}
		printf("%d %s", book->id, book->name);
	}
}

void Print(struct Student * book, int id) {
	if (book == NULL) {
		printf("the address list is empty!");
		return;
	} else {
		while (book->next != NULL)
		{
			if (book->id == id)
				printf("%d %s\n", book->id, book->name);
			book = book->next;
		}
		if (book->id == id)
			printf("%d %s", book->id, book->name);
	}
}

struct Student * Insert(struct Student * book) {
	struct Student *p =(struct Student *) malloc(sizeof(struct Student));
	struct Student *book1 = book;
	scanf("%d", &(p->id));
	scanf("%s", p->name);
	p->next = NULL;
	if (book == NULL) {
		return p;
	} else {
		while (book->next != NULL)
		{
			if (book->id == p->id) {
				printf("this id exist!");
				return book1;
			}
			book = book->next;
		}
		if (book->id != p->id)
			book->next = p;
		else
			printf("this id exist!"); 
	}
	return book1;
}
struct Student * Delete(struct Student * book, int id) {
	struct Student * book1 = book;
	if (book == NULL) {
		printf("the address list is empty!");
		return book;
	} else if (book->id == id) {
		struct Student *p = book;
		book = book->next;
		free(p);
		return book;
	} else {
		while (book->next != NULL) {
			if (book->next->id == id) {
				struct Student *p = book->next;
				book->next = book->next->next;
				free(p);
			}
		}
		return book1;
	}
}


int main(){
	struct Student * book1 = Creat();
	book1 = Insert(book1);
	book1 = Insert(book1); 
	Print(book1);
	/*Print(book1, 6);
	book1 = Delete(book1, 6);
	Print(book1);*/
	getchar(); getchar();
}