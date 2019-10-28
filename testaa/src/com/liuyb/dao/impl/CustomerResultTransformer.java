package com.liuyb.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.AliasedTupleSubsetResultTransformer;

public class CustomerResultTransformer extends AliasedTupleSubsetResultTransformer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final CustomerResultTransformer INSTANCE = new CustomerResultTransformer();

	final boolean addAlias;
	boolean filled;
	public static final int UPPER = 2;
	public static final int LOWER = 1;
	public static final int DEFAULT_CASE = 0;
	final int charCase;

	public CustomerResultTransformer(List<String> columns, int charCase) {
		if (charCase != 0) {
			columns = new ArrayList<String>();
		}
		aliases = columns;
		addAlias = this.aliases != null;
		this.charCase = charCase;
	}

	/**
	 * Disallow instantiation of AliasToEntityMapResultTransformer.
	 */
	private CustomerResultTransformer() {
		addAlias = false;
		filled = true;
		charCase = 0;
	}

	private List<String> aliases;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Object transformTuple(Object[] tuple, String[] aliases) {
		if (!filled && addAlias) {
			filled = true;
			for (int i = 0; i < aliases.length; i++) {
				String alias = aliases[i];
				if (alias == null) {
					alias = "";
				}
				this.aliases.add(charCase == 2 ? alias.toUpperCase() : (charCase == 1 ? alias.toLowerCase() : alias));
			}
		}

		@SuppressWarnings("rawtypes")
		Map result = new LinkedHashMap(tuple.length);
		if (this.aliases != null) {
			for (int i = 0; i < tuple.length; i++) {
				String alias = this.aliases.get(i);
				if (alias != null) {
					result.put(alias, tuple[i]);
				}
			}
		} else {
			for (int i = 0; i < tuple.length; i++) {
				String alias = aliases[i];
				if (alias != null) {
					result.put(alias, tuple[i]);
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
		return false;
	}

	/**
	 * Serialization hook for ensuring singleton uniqueing.
	 * 
	 * @return The singleton instance : {@link #INSTANCE}
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
