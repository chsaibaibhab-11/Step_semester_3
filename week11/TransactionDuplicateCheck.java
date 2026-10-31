import java.util.HashSet;
public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> set = new HashSet<>();
        for (String id : transactionIds) {
            if (!set.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] batch1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] batch2 = {"TXN2001", "TXN2002", "TXN2003"};
        System.out.println(hasDuplicate(batch1));
        System.out.println(hasDuplicate(batch2));
    }
}
