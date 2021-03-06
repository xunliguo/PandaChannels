package com.example.greendao1;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.administrator.pandachannels.fragmentobserve.entity.WenBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WEN_BEAN".
*/
public class WenBeanDao extends AbstractDao<WenBean, Void> {

    public static final String TABLENAME = "WEN_BEAN";

    /**
     * Properties of entity WenBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", false, "ID");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Source = new Property(2, String.class, "source", false, "SOURCE");
        public final static Property Pubtime = new Property(3, String.class, "pubtime", false, "PUBTIME");
        public final static Property Content = new Property(4, String.class, "content", false, "CONTENT");
        public final static Property Logo = new Property(5, String.class, "logo", false, "LOGO");
        public final static Property Guid = new Property(6, String.class, "guid", false, "GUID");
        public final static Property Url = new Property(7, String.class, "url", false, "URL");
        public final static Property Catalog = new Property(8, String.class, "catalog", false, "CATALOG");
        public final static Property Allow_share = new Property(9, String.class, "allow_share", false, "ALLOW_SHARE");
        public final static Property Allow_praise = new Property(10, String.class, "allow_praise", false, "ALLOW_PRAISE");
        public final static Property Allow_comment = new Property(11, String.class, "allow_comment", false, "ALLOW_COMMENT");
    };


    public WenBeanDao(DaoConfig config) {
        super(config);
    }
    
    public WenBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WEN_BEAN\" (" + //
                "\"ID\" TEXT," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"SOURCE\" TEXT," + // 2: source
                "\"PUBTIME\" TEXT," + // 3: pubtime
                "\"CONTENT\" TEXT," + // 4: content
                "\"LOGO\" TEXT," + // 5: logo
                "\"GUID\" TEXT," + // 6: guid
                "\"URL\" TEXT," + // 7: url
                "\"CATALOG\" TEXT," + // 8: catalog
                "\"ALLOW_SHARE\" TEXT," + // 9: allow_share
                "\"ALLOW_PRAISE\" TEXT," + // 10: allow_praise
                "\"ALLOW_COMMENT\" TEXT);"); // 11: allow_comment
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WEN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, WenBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(3, source);
        }
 
        String pubtime = entity.getPubtime();
        if (pubtime != null) {
            stmt.bindString(4, pubtime);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
 
        String logo = entity.getLogo();
        if (logo != null) {
            stmt.bindString(6, logo);
        }
 
        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(7, guid);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(8, url);
        }
 
        String catalog = entity.getCatalog();
        if (catalog != null) {
            stmt.bindString(9, catalog);
        }
 
        String allow_share = entity.getAllow_share();
        if (allow_share != null) {
            stmt.bindString(10, allow_share);
        }
 
        String allow_praise = entity.getAllow_praise();
        if (allow_praise != null) {
            stmt.bindString(11, allow_praise);
        }
 
        String allow_comment = entity.getAllow_comment();
        if (allow_comment != null) {
            stmt.bindString(12, allow_comment);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, WenBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(3, source);
        }
 
        String pubtime = entity.getPubtime();
        if (pubtime != null) {
            stmt.bindString(4, pubtime);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
 
        String logo = entity.getLogo();
        if (logo != null) {
            stmt.bindString(6, logo);
        }
 
        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(7, guid);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(8, url);
        }
 
        String catalog = entity.getCatalog();
        if (catalog != null) {
            stmt.bindString(9, catalog);
        }
 
        String allow_share = entity.getAllow_share();
        if (allow_share != null) {
            stmt.bindString(10, allow_share);
        }
 
        String allow_praise = entity.getAllow_praise();
        if (allow_praise != null) {
            stmt.bindString(11, allow_praise);
        }
 
        String allow_comment = entity.getAllow_comment();
        if (allow_comment != null) {
            stmt.bindString(12, allow_comment);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public WenBean readEntity(Cursor cursor, int offset) {
        WenBean entity = new WenBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // source
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // pubtime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // content
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // logo
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // guid
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // url
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // catalog
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // allow_share
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // allow_praise
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // allow_comment
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, WenBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSource(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPubtime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContent(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLogo(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setGuid(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUrl(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCatalog(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAllow_share(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setAllow_praise(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAllow_comment(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(WenBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(WenBean entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
