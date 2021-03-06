// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class LinkedHashTreeMap extends AbstractMap
    implements Serializable
{

    static final boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER = new _cls1();
    Comparator comparator;
    private EntrySet entrySet;
    final Node header;
    private KeySet keySet;
    int modCount;
    int size;
    Node table[];
    int threshold;

    public LinkedHashTreeMap()
    {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator comparator1)
    {
        size = 0;
        modCount = 0;
        if (comparator1 == null)
        {
            comparator1 = NATURAL_ORDER;
        }
        comparator = comparator1;
        header = new Node();
        table = new Node[16];
        threshold = table.length / 2 + table.length / 4;
    }

    private void doubleCapacity()
    {
        table = doubleCapacity(table);
        threshold = table.length / 2 + table.length / 4;
    }

    static Node[] doubleCapacity(Node anode[])
    {
        int l = anode.length;
        Node anode1[] = new Node[l * 2];
        AvlIterator avliterator = new AvlIterator();
        AvlBuilder avlbuilder = new AvlBuilder();
        AvlBuilder avlbuilder1 = new AvlBuilder();
        int i = 0;
        while (i < l) 
        {
            Node node = anode[i];
            if (node != null)
            {
                avliterator.reset(node);
                int k = 0;
                int j = 0;
                do
                {
                    Node node1 = avliterator.next();
                    if (node1 == null)
                    {
                        break;
                    }
                    if ((node1.hash & l) == 0)
                    {
                        j++;
                    } else
                    {
                        k++;
                    }
                } while (true);
                avlbuilder.reset(j);
                avlbuilder1.reset(k);
                avliterator.reset(node);
                do
                {
                    node = avliterator.next();
                    if (node == null)
                    {
                        break;
                    }
                    if ((node.hash & l) == 0)
                    {
                        avlbuilder.add(node);
                    } else
                    {
                        avlbuilder1.add(node);
                    }
                } while (true);
                if (j > 0)
                {
                    node = avlbuilder.root();
                } else
                {
                    node = null;
                }
                anode1[i] = node;
                if (k > 0)
                {
                    node = avlbuilder1.root();
                } else
                {
                    node = null;
                }
                anode1[i + l] = node;
            }
            i++;
        }
        return anode1;
    }

    private boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void rebalance(Node node, boolean flag)
    {
_L6:
        if (node == null) goto _L2; else goto _L1
_L1:
        Node node1;
        Node node2;
        int i;
        int j;
        int k;
        node1 = node.left;
        node2 = node.right;
        Node node4;
        if (node1 != null)
        {
            i = node1.height;
        } else
        {
            i = 0;
        }
        if (node2 != null)
        {
            j = node2.height;
        } else
        {
            j = 0;
        }
        k = i - j;
        if (k != -2) goto _L4; else goto _L3
_L3:
        node1 = node2.left;
        node4 = node2.right;
        if (node4 != null)
        {
            i = node4.height;
        } else
        {
            i = 0;
        }
        if (node1 != null)
        {
            j = node1.height;
        } else
        {
            j = 0;
        }
        i = j - i;
        if (i == -1 || i == 0 && !flag)
        {
            rotateLeft(node);
        } else
        {
            if (!$assertionsDisabled && i != 1)
            {
                throw new AssertionError();
            }
            rotateRight(node2);
            rotateLeft(node);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        node = node.parent;
          goto _L6
_L4:
        if (k != 2) goto _L8; else goto _L7
_L7:
        Node node3 = node1.left;
        Node node5 = node1.right;
        if (node5 != null)
        {
            i = node5.height;
        } else
        {
            i = 0;
        }
        if (node3 != null)
        {
            j = node3.height;
        } else
        {
            j = 0;
        }
        i = j - i;
        if (i == 1 || i == 0 && !flag)
        {
            rotateRight(node);
        } else
        {
            if (!$assertionsDisabled && i != -1)
            {
                throw new AssertionError();
            }
            rotateLeft(node1);
            rotateRight(node);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L8:
        if (k == 0)
        {
            node.height = i + 1;
            if (flag)
            {
                return;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (!$assertionsDisabled && k != -1 && k != 1)
        {
            throw new AssertionError();
        }
        node.height = Math.max(i, j) + 1;
        if (!flag) goto _L2; else goto _L5
    }

    private void replaceInParent(Node node, Node node1)
    {
        Node node2 = node.parent;
        node.parent = null;
        if (node1 != null)
        {
            node1.parent = node2;
        }
        if (node2 != null)
        {
            if (node2.left == node)
            {
                node2.left = node1;
                return;
            }
            if (!$assertionsDisabled && node2.right != node)
            {
                throw new AssertionError();
            } else
            {
                node2.right = node1;
                return;
            }
        } else
        {
            int i = node.hash;
            int j = table.length;
            table[i & j - 1] = node1;
            return;
        }
    }

    private void rotateLeft(Node node)
    {
        boolean flag = false;
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node2.left;
        Node node4 = node2.right;
        node.right = node3;
        if (node3 != null)
        {
            node3.parent = node;
        }
        replaceInParent(node, node2);
        node2.left = node;
        node.parent = node2;
        int i;
        int j;
        if (node1 != null)
        {
            i = node1.height;
        } else
        {
            i = 0;
        }
        if (node3 != null)
        {
            j = node3.height;
        } else
        {
            j = 0;
        }
        node.height = Math.max(i, j) + 1;
        j = node.height;
        i = ((flag) ? 1 : 0);
        if (node4 != null)
        {
            i = node4.height;
        }
        node2.height = Math.max(j, i) + 1;
    }

    private void rotateRight(Node node)
    {
        boolean flag = false;
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node1.left;
        Node node4 = node1.right;
        node.left = node4;
        if (node4 != null)
        {
            node4.parent = node;
        }
        replaceInParent(node, node1);
        node1.right = node;
        node.parent = node1;
        int i;
        int j;
        if (node2 != null)
        {
            i = node2.height;
        } else
        {
            i = 0;
        }
        if (node4 != null)
        {
            j = node4.height;
        } else
        {
            j = 0;
        }
        node.height = Math.max(i, j) + 1;
        j = node.height;
        i = ((flag) ? 1 : 0);
        if (node3 != null)
        {
            i = node3.height;
        }
        node1.height = Math.max(j, i) + 1;
    }

    private static int secondaryHash(int i)
    {
        i = i >>> 20 ^ i >>> 12 ^ i;
        return i >>> 4 ^ (i >>> 7 ^ i);
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    public final void clear()
    {
        Arrays.fill(table, null);
        size = 0;
        modCount = modCount + 1;
        Node node2 = header;
        Node node1;
        for (Node node = node2.next; node != node2; node = node1)
        {
            node1 = node.next;
            node.prev = null;
            node.next = null;
        }

        node2.prev = node2;
        node2.next = node2;
    }

    public final boolean containsKey(Object obj)
    {
        return findByObject(obj) != null;
    }

    public final Set entrySet()
    {
        EntrySet entryset = entrySet;
        if (entryset != null)
        {
            return entryset;
        } else
        {
            EntrySet entryset1 = new EntrySet();
            entrySet = entryset1;
            return entryset1;
        }
    }

    final Node find(Object obj, boolean flag)
    {
        Node node;
        Node node1;
        Object obj1;
        Node anode[];
        Comparator comparator1;
        int i;
        int j;
        int k;
        obj1 = null;
        comparator1 = comparator;
        anode = table;
        j = secondaryHash(obj.hashCode());
        k = j & anode.length - 1;
        node = anode[k];
        if (node == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        Comparable comparable;
        if (comparator1 == NATURAL_ORDER)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L3:
        if (comparable != null)
        {
            i = comparable.compareTo(node.key);
        } else
        {
            i = comparator1.compare(obj, node.key);
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        node1 = node;
_L5:
        return node1;
_L2:
label0:
        {
            if (i < 0)
            {
                node1 = node.left;
            } else
            {
                node1 = node.right;
            }
            if (node1 == null)
            {
                break label0;
            }
            node = node1;
        }
          goto _L3
        if (!flag) goto _L5; else goto _L4
_L4:
        Node node2 = header;
        if (node == null)
        {
            if (comparator1 == NATURAL_ORDER && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            obj = new Node(node, obj, j, node2, node2.prev);
            anode[k] = ((Node) (obj));
        } else
        {
            obj = new Node(node, obj, j, node2, node2.prev);
            if (i < 0)
            {
                node.left = ((Node) (obj));
            } else
            {
                node.right = ((Node) (obj));
            }
            rebalance(node, true);
        }
        i = size;
        size = i + 1;
        if (i > threshold)
        {
            doubleCapacity();
        }
        modCount = modCount + 1;
        return ((Node) (obj));
        i = 0;
        node1 = obj1;
        continue; /* Loop/switch isn't completed */
    }

    final Node findByEntry(java.util.Map.Entry entry)
    {
        Node node = findByObject(entry.getKey());
        boolean flag;
        if (node != null && equal(node.value, entry.getValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return node;
        } else
        {
            return null;
        }
    }

    final Node findByObject(Object obj)
    {
        Node node = null;
        if (obj != null)
        {
            try
            {
                node = find(obj, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
        }
        return node;
    }

    public final Object get(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            return ((Node) (obj)).value;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        KeySet keyset = keySet;
        if (keyset != null)
        {
            return keyset;
        } else
        {
            KeySet keyset1 = new KeySet();
            keySet = keyset1;
            return keyset1;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            obj = find(obj, true);
            Object obj2 = ((Node) (obj)).value;
            obj.value = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        obj = removeInternalByKey(obj);
        if (obj != null)
        {
            return ((Node) (obj)).value;
        } else
        {
            return null;
        }
    }

    final void removeInternal(Node node, boolean flag)
    {
        int j = 0;
        if (flag)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node.parent;
        if (node1 != null && node2 != null)
        {
            int i;
            if (node1.height > node2.height)
            {
                node1 = node1.last();
            } else
            {
                node1 = node2.first();
            }
            removeInternal(node1, false);
            node2 = node.left;
            if (node2 != null)
            {
                i = node2.height;
                node1.left = node2;
                node2.parent = node1;
                node.left = null;
            } else
            {
                i = 0;
            }
            node2 = node.right;
            if (node2 != null)
            {
                j = node2.height;
                node1.right = node2;
                node2.parent = node1;
                node.right = null;
            }
            node1.height = Math.max(i, j) + 1;
            replaceInParent(node, node1);
            return;
        }
        if (node1 != null)
        {
            replaceInParent(node, node1);
            node.left = null;
        } else
        if (node2 != null)
        {
            replaceInParent(node, node2);
            node.right = null;
        } else
        {
            replaceInParent(node, null);
        }
        rebalance(node3, false);
        size = size - 1;
        modCount = modCount + 1;
    }

    final Node removeInternalByKey(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            removeInternal(((Node) (obj)), true);
        }
        return ((Node) (obj));
    }

    public final int size()
    {
        return size;
    }

    static 
    {
        boolean flag;
        if (!com/google/gson/internal/LinkedHashTreeMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class Node
        implements java.util.Map.Entry
    {

        final int hash;
        int height;
        final Object key;
        Node left;
        Node next;
        Node parent;
        Node prev;
        Node right;
        Object value;

        public final boolean equals(Object obj)
        {
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = flag1;
            if (!(obj instanceof java.util.Map.Entry)) goto _L2; else goto _L1
_L1:
            obj = (java.util.Map.Entry)obj;
            if (key != null) goto _L4; else goto _L3
_L3:
            flag = flag1;
            if (((java.util.Map.Entry) (obj)).getKey() != null) goto _L2; else goto _L5
_L5:
            if (value != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((java.util.Map.Entry) (obj)).getValue() != null) goto _L2; else goto _L8
_L8:
            flag = true;
_L2:
            return flag;
_L4:
            flag = flag1;
            if (!key.equals(((java.util.Map.Entry) (obj)).getKey())) goto _L2; else goto _L5
_L7:
            flag = flag1;
            if (!value.equals(((java.util.Map.Entry) (obj)).getValue())) goto _L2; else goto _L8
        }

        public final Node first()
        {
            Node node = left;
            Node node1 = this;
            Node node2;
            for (; node != null; node = node2)
            {
                node2 = node.left;
                node1 = node;
            }

            return node1;
        }

        public final Object getKey()
        {
            return key;
        }

        public final Object getValue()
        {
            return value;
        }

        public final int hashCode()
        {
            int j = 0;
            int i;
            if (key == null)
            {
                i = 0;
            } else
            {
                i = key.hashCode();
            }
            if (value != null)
            {
                j = value.hashCode();
            }
            return i ^ j;
        }

        public final Node last()
        {
            Node node = right;
            Node node1 = this;
            Node node2;
            for (; node != null; node = node2)
            {
                node2 = node.right;
                node1 = node;
            }

            return node1;
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = value;
            value = obj;
            return obj1;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(key).append("=").append(value).toString();
        }

        Node()
        {
            key = null;
            hash = -1;
            prev = this;
            next = this;
        }

        Node(Node node, Object obj, int i, Node node1, Node node2)
        {
            parent = node;
            key = obj;
            hash = i;
            height = 1;
            next = node1;
            prev = node2;
            node2.next = this;
            node1.prev = this;
        }
    }


    private class AvlIterator
    {

        private Node stackTop;

        public Node next()
        {
            Node node3 = stackTop;
            if (node3 == null)
            {
                return null;
            }
            Node node1 = node3.parent;
            node3.parent = null;
            Node node2;
            for (Node node = node3.right; node != null; node = node2)
            {
                node.parent = node1;
                node2 = node.left;
                node1 = node;
            }

            stackTop = node1;
            return node3;
        }

        void reset(Node node)
        {
            Node node1 = null;
            Node node2;
            for (; node != null; node = node2)
            {
                node.parent = node1;
                node2 = node.left;
                node1 = node;
            }

            stackTop = node1;
        }

        AvlIterator()
        {
        }
    }


    private class AvlBuilder
    {

        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node stack;

        final void add(Node node)
        {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            if (leavesToSkip > 0 && (size & 1) == 0)
            {
                size = size + 1;
                leavesToSkip = leavesToSkip - 1;
                leavesSkipped = leavesSkipped + 1;
            }
            node.parent = stack;
            stack = node;
            size = size + 1;
            if (leavesToSkip > 0 && (size & 1) == 0)
            {
                size = size + 1;
                leavesToSkip = leavesToSkip - 1;
                leavesSkipped = leavesSkipped + 1;
            }
            int i = 4;
            while ((size & i - 1) == i - 1) 
            {
                if (leavesSkipped == 0)
                {
                    node = stack;
                    Node node1 = node.parent;
                    Node node3 = node1.parent;
                    node1.parent = node3.parent;
                    stack = node1;
                    node1.left = node3;
                    node1.right = node;
                    node1.height = node.height + 1;
                    node3.parent = node1;
                    node.parent = node1;
                } else
                if (leavesSkipped == 1)
                {
                    node = stack;
                    Node node2 = node.parent;
                    stack = node2;
                    node2.right = node;
                    node2.height = node.height + 1;
                    node.parent = node2;
                    leavesSkipped = 0;
                } else
                if (leavesSkipped == 2)
                {
                    leavesSkipped = 0;
                }
                i *= 2;
            }
        }

        final void reset(int i)
        {
            leavesToSkip = Integer.highestOneBit(i) * 2 - 1 - i;
            size = 0;
            leavesSkipped = 0;
            stack = null;
        }

        final Node root()
        {
            Node node = stack;
            if (node.parent != null)
            {
                throw new IllegalStateException();
            } else
            {
                return node;
            }
        }

        AvlBuilder()
        {
        }
    }


    private class EntrySet extends AbstractSet
    {

        final LinkedHashTreeMap this$0;

        public final void clear()
        {
            LinkedHashTreeMap.this.clear();
        }

        public final boolean contains(Object obj)
        {
            return (obj instanceof java.util.Map.Entry) && findByEntry((java.util.Map.Entry)obj) != null;
        }

        public final Iterator iterator()
        {
            class _cls1 extends LinkedTreeMapIterator
            {
                private class LinkedTreeMapIterator
                    implements Iterator
                {

                    int expectedModCount;
                    Node lastReturned;
                    Node next;
                    final LinkedHashTreeMap this$0;

                    public final boolean hasNext()
                    {
                        return next != header;
                    }

                    final Node nextNode()
                    {
                        Node node = next;
                        if (node == header)
                        {
                            throw new NoSuchElementException();
                        }
                        if (modCount != expectedModCount)
                        {
                            throw new ConcurrentModificationException();
                        } else
                        {
                            next = node.next;
                            lastReturned = node;
                            return node;
                        }
                    }

                    public final void remove()
                    {
                        if (lastReturned == null)
                        {
                            throw new IllegalStateException();
                        } else
                        {
                            removeInternal(lastReturned, true);
                            lastReturned = null;
                            expectedModCount = modCount;
                            return;
                        }
                    }

                    private LinkedTreeMapIterator()
                    {
                        this$0 = LinkedHashTreeMap.this;
                        super();
                        next = header.next;
                        lastReturned = null;
                        expectedModCount = modCount;
                    }

                    LinkedTreeMapIterator(_cls1 _pcls1)
                    {
                        this();
                    }
                }


                final EntrySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public java.util.Map.Entry next()
                {
                    return nextNode();
                }

                _cls1()
                {
                    this$1 = EntrySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public final boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                if ((obj = findByEntry((java.util.Map.Entry)obj)) != null)
                {
                    removeInternal(((Node) (obj)), true);
                    return true;
                }
            }
            return false;
        }

        public final int size()
        {
            return LinkedHashTreeMap.this.size;
        }

        EntrySet()
        {
            this$0 = LinkedHashTreeMap.this;
            super();
        }
    }


    private class KeySet extends AbstractSet
    {

        final LinkedHashTreeMap this$0;

        public final void clear()
        {
            LinkedHashTreeMap.this.clear();
        }

        public final boolean contains(Object obj)
        {
            return containsKey(obj);
        }

        public final Iterator iterator()
        {
            class _cls1 extends LinkedTreeMapIterator
            {

                final KeySet this$1;

                public Object next()
                {
                    return nextNode().key;
                }

                _cls1()
                {
                    this$1 = KeySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public final boolean remove(Object obj)
        {
            return removeInternalByKey(obj) != null;
        }

        public final int size()
        {
            return LinkedHashTreeMap.this.size;
        }

        KeySet()
        {
            this$0 = LinkedHashTreeMap.this;
            super();
        }
    }


    private class _cls1
        implements Comparator
    {

        public final int compare(Comparable comparable, Comparable comparable1)
        {
            return comparable.compareTo(comparable1);
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((Comparable)obj, (Comparable)obj1);
        }

        _cls1()
        {
        }
    }

}
