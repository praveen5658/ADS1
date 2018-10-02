class Sorting {
	Team[] team;
	int size;
	Sorting() {
		team = new Team[20];
		this.size = 0;
	}
	public void add(Team t) {
		team[size++] = t;
	}
	public int size() {
		return size;
	}
// time complexity for this method is O(N^2).
// In first for loop and second loop it iterates through the size of array
	public void selection() {
		for (int i = 0;i < size; i++) {
			int min = i;
    		for (int j = i + 1; j < size; j++) {
         		if (team[j].compareTo(team[min]) > -1) {
             		min = j;
	            }
    		}
    		swap(team, i, min);
		}
	}
// time complexity of this method is O(1). It swaps the elements only once.
	public void swap(Team[] team, int i, int min) {
		Team temp = team[min];
	    team[min] = team[i];
	    team[i] = temp;
	}
// time complexity of this method is O(N). It iterates through
// the array to print all the objects in array.
	public String toString() {
		String str = "";
		for (int i = 0; i < size - 1; i++) {
			str += team[i].getName() + ",";
		}
		str += team[size - 1].getName();
		return str;
	}
}