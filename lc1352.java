import java.util.ArrayList;

class LC1352 {
    class ProductOfNumbers {
        private ArrayList<Integer> strm;
        private ArrayList<Integer> productPrefix;

        public ProductOfNumbers() {
            this.strm = new ArrayList<>();
            this.productPrefix = new ArrayList<>();
        }

        public void add(int num) {
            this.strm.add(num);
            if (num == 0) {
                productPrefix.clear();
            } else if (productPrefix.isEmpty()) {
                productPrefix.add(num);
            } else {
                int prev = productPrefix.get(productPrefix.size() - 1);
                productPrefix.add(prev * num);
            }
        }

        public int getProduct(int k) {
            if (productPrefix.isEmpty() || productPrefix.size() < k)
                return 0;
            if (productPrefix.size() == k)
                return productPrefix.get(productPrefix.size() - 1);
            return productPrefix.get(productPrefix.size() - 1) / productPrefix.get(productPrefix.size() - k - 1);

        }
    }

    public static void main(String[] args) {
        LC1352 solution = new LC1352();

    }
}
