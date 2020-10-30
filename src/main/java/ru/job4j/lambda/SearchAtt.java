package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
	public static List<Attachment> filter(Predicate<Attachment> fun, List<Attachment> list) {
		List<Attachment> res = new ArrayList<>();
		for (Attachment att : list) {
			if (fun.test(att)) {
				res.add(att);
			}
		}
		return res;
	}

	public static List<Attachment> filterSize(List<Attachment> list) {
		Predicate<Attachment> fun = new Predicate<Attachment>() {
			@Override
			public boolean test(Attachment attachment) {
				boolean res = false;
				if (attachment.getSize() > 100) {
					res = true;
				}
				return res;
			}
		};
		return filter(fun, list);
	}

	public static List<Attachment> filterName(List<Attachment> list) {
		Predicate<Attachment> fun = new Predicate<Attachment>() {
			@Override
			public boolean test(Attachment attachment) {
				boolean res = false;
				if (attachment.getName().contains("bug")) {
					res = true;
				}
				return res;
			}
		};
		return filter(fun, list);
	}
}
