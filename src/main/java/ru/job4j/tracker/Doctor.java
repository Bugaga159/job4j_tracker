package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Profession {
	private List<OperationInHospital> itemOperation = new ArrayList<OperationInHospital>();

	public List<OperationInHospital> getItemOperation() {
		return itemOperation;
	}

	public Diagnosis heal(Pacient pacient) {
		return null;
	}

	public void creatOperation(OperationInHospital operation) {
		itemOperation.add(operation);
	}
}
