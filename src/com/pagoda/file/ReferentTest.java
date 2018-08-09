package com.pagoda.file;


public class ReferentTest {
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("ReferentTest's finalize called");
	}

	@Override
	public String toString() {
		return "i am ReferentTest";
	}


}
