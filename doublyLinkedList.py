class doublyLinkedList:
    def __init__(self, value, pre=None, next=None):
        self.value = value
        self.pre = pre
        self.next = next

    def __str__(self):
        return str(self.value)


if __name__ == '__main__':
    head = None
    n = int(input('No\'s: '))
    for _ in range(n):
        value = int(input('No. = ? '))
        if head is None:
            head = doublyLinkedList(value)
            curr = head
        else:
            new = doublyLinkedList(value)
            curr.next = new
            new.pre = curr
            curr = new

    curr = head
    print('Head to tail')
    while curr:
        print(curr)
        curr = curr.next

    print('Tail to head')
    curr = head
    while True:
        if curr.next is None:
            break
        else:
            curr = curr.next
    while curr:
        print(curr)
        curr = curr.pre

#comment