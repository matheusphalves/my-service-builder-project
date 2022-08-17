/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.h7g5.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.h7g5.exception.NoSuchH7G5FolderException;
import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.h7g5.service.H7G5FolderLocalServiceUtil;
import com.liferay.h7g5.service.persistence.H7G5FolderPersistence;
import com.liferay.h7g5.service.persistence.H7G5FolderUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class H7G5FolderPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.h7g5.service"));

	@Before
	public void setUp() {
		_persistence = H7G5FolderUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<H7G5Folder> iterator = _h7g5Folders.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G5Folder h7g5Folder = _persistence.create(pk);

		Assert.assertNotNull(h7g5Folder);

		Assert.assertEquals(h7g5Folder.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		_persistence.remove(newH7G5Folder);

		H7G5Folder existingH7G5Folder = _persistence.fetchByPrimaryKey(
			newH7G5Folder.getPrimaryKey());

		Assert.assertNull(existingH7G5Folder);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addH7G5Folder();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G5Folder newH7G5Folder = _persistence.create(pk);

		newH7G5Folder.setGroupId(RandomTestUtil.nextLong());

		newH7G5Folder.setCompanyId(RandomTestUtil.nextLong());

		newH7G5Folder.setUserId(RandomTestUtil.nextLong());

		newH7G5Folder.setUserName(RandomTestUtil.randomString());

		newH7G5Folder.setCreateDate(RandomTestUtil.nextDate());

		newH7G5Folder.setModifiedDate(RandomTestUtil.nextDate());

		newH7G5Folder.setDescription(RandomTestUtil.randomString());

		newH7G5Folder.setName(RandomTestUtil.randomString());

		_h7g5Folders.add(_persistence.update(newH7G5Folder));

		H7G5Folder existingH7G5Folder = _persistence.findByPrimaryKey(
			newH7G5Folder.getPrimaryKey());

		Assert.assertEquals(
			existingH7G5Folder.getH7g5FolderId(),
			newH7G5Folder.getH7g5FolderId());
		Assert.assertEquals(
			existingH7G5Folder.getGroupId(), newH7G5Folder.getGroupId());
		Assert.assertEquals(
			existingH7G5Folder.getCompanyId(), newH7G5Folder.getCompanyId());
		Assert.assertEquals(
			existingH7G5Folder.getUserId(), newH7G5Folder.getUserId());
		Assert.assertEquals(
			existingH7G5Folder.getUserName(), newH7G5Folder.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G5Folder.getCreateDate()),
			Time.getShortTimestamp(newH7G5Folder.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G5Folder.getModifiedDate()),
			Time.getShortTimestamp(newH7G5Folder.getModifiedDate()));
		Assert.assertEquals(
			existingH7G5Folder.getDescription(),
			newH7G5Folder.getDescription());
		Assert.assertEquals(
			existingH7G5Folder.getName(), newH7G5Folder.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		H7G5Folder existingH7G5Folder = _persistence.findByPrimaryKey(
			newH7G5Folder.getPrimaryKey());

		Assert.assertEquals(existingH7G5Folder, newH7G5Folder);
	}

	@Test(expected = NoSuchH7G5FolderException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<H7G5Folder> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"OHQIWTSFHL_H7G5Folder", "h7g5FolderId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "description", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		H7G5Folder existingH7G5Folder = _persistence.fetchByPrimaryKey(
			newH7G5Folder.getPrimaryKey());

		Assert.assertEquals(existingH7G5Folder, newH7G5Folder);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G5Folder missingH7G5Folder = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingH7G5Folder);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		H7G5Folder newH7G5Folder1 = addH7G5Folder();
		H7G5Folder newH7G5Folder2 = addH7G5Folder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G5Folder1.getPrimaryKey());
		primaryKeys.add(newH7G5Folder2.getPrimaryKey());

		Map<Serializable, H7G5Folder> h7g5Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, h7g5Folders.size());
		Assert.assertEquals(
			newH7G5Folder1, h7g5Folders.get(newH7G5Folder1.getPrimaryKey()));
		Assert.assertEquals(
			newH7G5Folder2, h7g5Folders.get(newH7G5Folder2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, H7G5Folder> h7g5Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g5Folders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		H7G5Folder newH7G5Folder = addH7G5Folder();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G5Folder.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, H7G5Folder> h7g5Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g5Folders.size());
		Assert.assertEquals(
			newH7G5Folder, h7g5Folders.get(newH7G5Folder.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, H7G5Folder> h7g5Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g5Folders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G5Folder.getPrimaryKey());

		Map<Serializable, H7G5Folder> h7g5Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g5Folders.size());
		Assert.assertEquals(
			newH7G5Folder, h7g5Folders.get(newH7G5Folder.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			H7G5FolderLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<H7G5Folder>() {

				@Override
				public void performAction(H7G5Folder h7g5Folder) {
					Assert.assertNotNull(h7g5Folder);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G5Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g5FolderId", newH7G5Folder.getH7g5FolderId()));

		List<H7G5Folder> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		H7G5Folder existingH7G5Folder = result.get(0);

		Assert.assertEquals(existingH7G5Folder, newH7G5Folder);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G5Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g5FolderId", RandomTestUtil.nextLong()));

		List<H7G5Folder> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		H7G5Folder newH7G5Folder = addH7G5Folder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G5Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g5FolderId"));

		Object newH7g5FolderId = newH7G5Folder.getH7g5FolderId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g5FolderId", new Object[] {newH7g5FolderId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingH7g5FolderId = result.get(0);

		Assert.assertEquals(existingH7g5FolderId, newH7g5FolderId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G5Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g5FolderId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g5FolderId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected H7G5Folder addH7G5Folder() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G5Folder h7g5Folder = _persistence.create(pk);

		h7g5Folder.setGroupId(RandomTestUtil.nextLong());

		h7g5Folder.setCompanyId(RandomTestUtil.nextLong());

		h7g5Folder.setUserId(RandomTestUtil.nextLong());

		h7g5Folder.setUserName(RandomTestUtil.randomString());

		h7g5Folder.setCreateDate(RandomTestUtil.nextDate());

		h7g5Folder.setModifiedDate(RandomTestUtil.nextDate());

		h7g5Folder.setDescription(RandomTestUtil.randomString());

		h7g5Folder.setName(RandomTestUtil.randomString());

		_h7g5Folders.add(_persistence.update(h7g5Folder));

		return h7g5Folder;
	}

	private List<H7G5Folder> _h7g5Folders = new ArrayList<H7G5Folder>();
	private H7G5FolderPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}