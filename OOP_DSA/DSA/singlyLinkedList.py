class singlyLinkedList:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def __str__(self):
        return str(self.value)


if __name__ == '__main__':
    head = None
    curr = head
    n = int(input('No\'s: '))
    for _ in range(n):
        value = int(input('No. = ? '))
        if head is None:
            head = singlyLinkedList(value)
            curr = head
        else:
            new = singlyLinkedList(value)
            curr.next = new
            curr = new
    curr = head
    while curr:
        print(curr)
        curr = curr.next
    print(head.next)


#comment