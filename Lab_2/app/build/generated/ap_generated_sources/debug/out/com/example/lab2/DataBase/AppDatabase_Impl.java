package com.example.lab2.DataBase;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile TimerDao _timerDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TimerModel` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `Preparation` INTEGER NOT NULL, `WorkTime` INTEGER NOT NULL, `RestTime` INTEGER NOT NULL, `Cycles` INTEGER NOT NULL, `Sets` INTEGER NOT NULL, `RestSets` INTEGER NOT NULL, `Color` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '16f184dd3c47312853b90eb18cdc2c29')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TimerModel`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTimerModel = new HashMap<String, TableInfo.Column>(9);
        _columnsTimerModel.put("Id", new TableInfo.Column("Id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("Name", new TableInfo.Column("Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("Preparation", new TableInfo.Column("Preparation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("WorkTime", new TableInfo.Column("WorkTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("RestTime", new TableInfo.Column("RestTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("Cycles", new TableInfo.Column("Cycles", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("Sets", new TableInfo.Column("Sets", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("RestSets", new TableInfo.Column("RestSets", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimerModel.put("Color", new TableInfo.Column("Color", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTimerModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTimerModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTimerModel = new TableInfo("TimerModel", _columnsTimerModel, _foreignKeysTimerModel, _indicesTimerModel);
        final TableInfo _existingTimerModel = TableInfo.read(_db, "TimerModel");
        if (! _infoTimerModel.equals(_existingTimerModel)) {
          return new RoomOpenHelper.ValidationResult(false, "TimerModel(com.example.lab2.Models.TimerModel).\n"
                  + " Expected:\n" + _infoTimerModel + "\n"
                  + " Found:\n" + _existingTimerModel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "16f184dd3c47312853b90eb18cdc2c29", "3695694b689877d69d8fdc4c2c4d1791");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "TimerModel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `TimerModel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public TimerDao timerDao() {
    if (_timerDao != null) {
      return _timerDao;
    } else {
      synchronized(this) {
        if(_timerDao == null) {
          _timerDao = new TimerDao_Impl(this);
        }
        return _timerDao;
      }
    }
  }
}
