class MeritOrderSort {
	protected MeritOrderSort() {

	}
	public StudentData[] sort(final StudentData[] sd) {
		StudentData[] studentdata = sd;
		int minposition = 0;
		for (int i = 0; i < studentdata.length; i++) {
			minposition = i;
			for (int j = i + 1; j < studentdata.length; j++) {
				if (studentdata[minposition].gettotalmarks()
				        < studentdata[j].gettotalmarks()) {
					minposition = j;
				} else if (studentdata[minposition].gettotalmarks()
				           == studentdata[j].gettotalmarks()) {
					if (studentdata[minposition].getsubject3marks()
					        < studentdata[j].getsubject3marks()) {
						minposition = j;
					} else if (studentdata[minposition].getsubject3marks()
					           == studentdata[j].getsubject3marks()) {
						if (studentdata[minposition].getsubject2marks()
						        < studentdata[j].getsubject2marks()) {
							minposition = j;
						} else if (studentdata[minposition].getsubject2marks()
						           == studentdata[j].getsubject2marks()) {
							if (comparedate(studentdata[minposition].getdob(),
							                studentdata[j].getdob())) {
								minposition = j;
							}
						}
					}
				}
			}
			if (minposition != i){
				StudentData sample = studentdata[minposition];
				studentdata[minposition] = studentdata[i];
				studentdata[i] = sample;
			}
		}
		return studentdata;
	}
	public boolean comparedate(final String dobmin, final String dobj){
		int c = dobmin.compareTo(dobj);
		if (c < 0){
			return false;
		}
		return true;
	}
}