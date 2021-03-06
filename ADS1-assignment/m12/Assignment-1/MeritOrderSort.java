class MeritOrderSort {
	/**
	 * Constructs the object.
	 */
	protected MeritOrderSort() {

	}
	/**
	 * { Sort method }.
	 *
	 * @param      sd    { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
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
							// System.out.println(studentdata[minposition].getdob());
							// System.out.println(studentdata[j].getdob());
							if (comparedate(studentdata[minposition].getdob(),
							                studentdata[j].getdob())) {
								minposition = j;
							}
						}
					}
				}
			}
			if (minposition != i) {
				StudentData sample = studentdata[minposition];
				studentdata[minposition] = studentdata[i];
				studentdata[i] = sample;
			}
		}
		return studentdata;
	}
	/**
	 * { CompareData }.
	 *
	 * @param      dobmin  The dobmin
	 * @param      dobj    The dobj
	 *
	 * @return     { boolean }.
	 */
	public boolean comparedate(final String dobmin, final String dobj) {
		int c = dobmin.compareTo(dobj);
		if (c > 0) {
			return false;
		}
		return true;
	}
}