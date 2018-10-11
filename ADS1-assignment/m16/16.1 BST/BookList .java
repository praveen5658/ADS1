class BookList<Key extends Comparable<Key>,Value> {
    String name;
    String author;
    Float cost;

    BookList(String name, String author, Float cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    /**
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int compareTo(BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
