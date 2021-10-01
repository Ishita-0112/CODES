class Solution {
    static Map<Integer, Integer> powers = new HashMap<>();
    static {
        powers.put(1, 0);
    }

    public int getKth(int lo, int hi, int k) {
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            int curPower = getPower(i);
            ans.add(new Pair<>(i, curPower));
        }
        ans.sort((p1, p2) -> {
            if ((int)p1.getValue() != p2.getValue()) {
                return p1.getValue().compareTo(p2.getValue());
            }
            return p1.getKey().compareTo(p2.getKey());
        });
        return ans.get(k - 1).getKey();
    }

    private int getPower(int num) {
        Integer pow = powers.get(num);
        if (pow != null) {
            return pow;
        }
        if (num % 2 == 0) {
            int power = getPower(num / 2) + 1;
            powers.put(num, power);
            return power;
        }
        int power = getPower(3 * num + 1) + 1;
        powers.put(num, power);
        return power;
    }
}
