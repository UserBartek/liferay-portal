/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.kernel.workflow.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowInstanceHistory;

import java.util.Date;

/**
 * <a href="WorkflowInstanceHistoryCreateDateComparator.java.html"><b><i>View
 * Source</i></b></a>
 *
 * @author Shuyang Zhou
 */
public class WorkflowInstanceHistoryCreateDateComparator
	extends OrderByComparator {

	public static String ORDER_BY_ASC = "createDate ASC, id ASC";
	public static String ORDER_BY_DESC = "createDate DESC, id DESC";
	public static String[] ORDER_BY_FIELDS = {"createDate", "id"};

	public WorkflowInstanceHistoryCreateDateComparator() {
		this(false);
	}

	public WorkflowInstanceHistoryCreateDateComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		WorkflowInstanceHistory history1 = (WorkflowInstanceHistory) obj1;
		WorkflowInstanceHistory history2 = (WorkflowInstanceHistory) obj2;

		Date createDate1 = history1.getCreateDate();
		Date createDate2 = history2.getCreateDate();

		int value = createDate1.compareTo(createDate2);

		if (value != 0) {
			Long historyId1 = history1.getHistoryEntryId();
			Long historyId2 = history2.getWorkflowInstanceId();
			value = historyId1.compareTo(historyId2);
		}

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _asc;
	}

	private boolean _asc;

}