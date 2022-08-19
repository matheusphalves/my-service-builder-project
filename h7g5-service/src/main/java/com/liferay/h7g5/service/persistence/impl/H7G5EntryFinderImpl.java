package com.liferay.h7g5.service.persistence.impl;

import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.h7g5.service.H7G5EntryLocalService;
import com.liferay.h7g5.service.persistence.H7G5EntryFinder;
import com.liferay.h7g5.service.H7G5EntryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * @author Matheus Alves
 */
@Component(service = H7G5EntryFinder.class)
public class H7G5EntryFinderImpl extends H7G5EntryFinderBaseImpl implements H7G5EntryFinder{

    public List<H7G5Entry> findByFolderId(long folderId) {
        Session session = null;

        try{

            session = (Session) openSession();

            ClassLoader classLoader = getClass().getClassLoader();

            Order order = OrderFactoryUtil.desc("modifiedDate");

            DynamicQuery h7g5EntryQuery = DynamicQueryFactoryUtil.forClass(H7G5Entry.class, classLoader)
                    .add(RestrictionsFactoryUtil.eq("entryFolderId", folderId))
                    .addOrder(order);

            List<H7G5Entry> entries = H7G5EntryLocalServiceUtil.dynamicQuery(h7g5EntryQuery);
            return entries;

        }catch (Exception ex){
            try {
                throw new SystemException(ex);
            } catch (SystemException se){
                se.printStackTrace();
            }
        } finally {
            closeSession(session);
        }

        return null;
    }

    public List<H7G5Entry> findByHDN(long entryFolderId, String entryDescription, String entryName){
        Session session = null;
        try{

            session = (Session) openSession();
            ClassLoader classLoader = getClass().getClassLoader();

            DynamicQuery h7g5EntryQuery = DynamicQueryFactoryUtil.forClass(H7G5Entry.class, classLoader)
                    .add(RestrictionsFactoryUtil.eq("h7g5FolderId", entryFolderId))
                    .add(RestrictionsFactoryUtil.eq("Description", entryDescription))
                    .add(RestrictionsFactoryUtil.eq("Name", entryName));

            List<H7G5Entry> entries = H7G5EntryLocalServiceUtil.dynamicQuery(h7g5EntryQuery);

            return entries;

        }catch (Exception ex){

            try {
                throw new SystemException(ex);
            } catch (SystemException se){
                se.printStackTrace();
            }
        }finally {
            closeSession(session);
        }
        return null;
    }

    public H7G5Entry findByKey(String entryKey) {
        Session session = null;
        try{

            session = (Session) openSession();
            ClassLoader classLoader = getClass().getClassLoader();

            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(H7G5Entry.class, classLoader)
                    .add(RestrictionsFactoryUtil.eq("Key", entryKey));

            List<H7G5Entry> entries = H7G5EntryLocalServiceUtil.dynamicQuery(entryQuery);

            return (H7G5Entry) entries;


        }catch (Exception ex){
            try {
                throw new SystemException(ex);
            }
            catch (SystemException se) {
                se.printStackTrace();
            }
        }finally {
            closeSession(session);
        }
        return null;
    }

    public List<H7G5Entry> findByName(String entryName) {

        Session session = null;

        try{

            session = (Session) openSession();

            ClassLoader classLoader = getClass().getClassLoader();

            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(H7G5Entry.class, classLoader)
                    .add(RestrictionsFactoryUtil.eq("name", entryName));

            List<H7G5Entry> entries = H7G5EntryLocalServiceUtil.dynamicQuery(entryQuery);

            return (List<H7G5Entry>)entries;

        }catch (Exception ex){
            try {
                throw new SystemException(ex);
            }
            catch (SystemException se) {
                se.printStackTrace();
            }
        }finally {
            closeSession(session);
        }

        return null;
    }

    @Reference
    private H7G5EntryLocalService _h7G5EntryLocalService;
}