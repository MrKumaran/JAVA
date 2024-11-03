class circularLinkedList:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def __str__(self):
        return str(self.value)


if __name__ == '__main__':
    head = None
    n = int(input('No\'s: '))
    for _ in range(n):
        value = int(input('No. = ? '))
        if head is None:
            head = circularLinkedList(value)
            curr = head
            curr.next = head
        else:
            new = circularLinkedList(value)
            new.next = head
            curr.next = new
            curr = new

    curr = head
    v = 1
    c = 0
    while curr:
        print(curr)
        curr = curr.next
        if curr == head:
            v = 2
            print("v ",v)
        elif curr is head and v == 2:
            break
        c += 1
        if c == 5:
            break

#comment