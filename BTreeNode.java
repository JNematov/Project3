public class BTreeNode {
    
    long id;     // • 8-bytes: The block id this node is stored in.
    long pid;    // • 8-bytes: The block id this nodes parent is located. If this node is the root, then this field is zero.
    long n;    // • 8-bytes: Number of key/value pairs currently in this node.
    long[] keys = new long[19]; // • 152-bytes: A sequence of 19 64-bit keys 
    long[] values = new long[19]; // • 152-bytes: A sequence of 19 64-bit values
    long[] offsets = new long[20];  // • 160-bytes: A sequence of 20 64-bit oﬀsets. These block ids are the child pointers for this node.
    // If a child is a leaf node, the corresponding id will be zero.
    byte[] unused = new byte[24]; 

}
