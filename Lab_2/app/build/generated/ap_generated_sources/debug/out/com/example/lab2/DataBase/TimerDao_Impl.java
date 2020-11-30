package com.example.lab2.DataBase;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lab2.Models.TimerModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TimerDao_Impl implements TimerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TimerModel> __insertionAdapterOfTimerModel;

  private final EntityDeletionOrUpdateAdapter<TimerModel> __deletionAdapterOfTimerModel;

  private final EntityDeletionOrUpdateAdapter<TimerModel> __updateAdapterOfTimerModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TimerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTimerModel = new EntityInsertionAdapter<TimerModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TimerModel` (`Id`,`Name`,`Preparation`,`WorkTime`,`RestTime`,`Cycles`,`Sets`,`RestSets`,`Color`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimerModel value) {
        stmt.bindLong(1, value.Id);
        if (value.Name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.Name);
        }
        stmt.bindLong(3, value.Preparation);
        stmt.bindLong(4, value.WorkTime);
        stmt.bindLong(5, value.RestTime);
        stmt.bindLong(6, value.Cycles);
        stmt.bindLong(7, value.Sets);
        stmt.bindLong(8, value.RestSets);
        stmt.bindLong(9, value.Color);
      }
    };
    this.__deletionAdapterOfTimerModel = new EntityDeletionOrUpdateAdapter<TimerModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TimerModel` WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimerModel value) {
        stmt.bindLong(1, value.Id);
      }
    };
    this.__updateAdapterOfTimerModel = new EntityDeletionOrUpdateAdapter<TimerModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TimerModel` SET `Id` = ?,`Name` = ?,`Preparation` = ?,`WorkTime` = ?,`RestTime` = ?,`Cycles` = ?,`Sets` = ?,`RestSets` = ?,`Color` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimerModel value) {
        stmt.bindLong(1, value.Id);
        if (value.Name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.Name);
        }
        stmt.bindLong(3, value.Preparation);
        stmt.bindLong(4, value.WorkTime);
        stmt.bindLong(5, value.RestTime);
        stmt.bindLong(6, value.Cycles);
        stmt.bindLong(7, value.Sets);
        stmt.bindLong(8, value.RestSets);
        stmt.bindLong(9, value.Color);
        stmt.bindLong(10, value.Id);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM timerModel";
        return _query;
      }
    };
  }

  @Override
  public void insert(final TimerModel timerModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTimerModel.insert(timerModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TimerModel timerModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTimerModel.handle(timerModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TimerModel timerModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTimerModel.handle(timerModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<TimerModel> getAll() {
    final String _sql = "SELECT * FROM timerModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
      final int _cursorIndexOfPreparation = CursorUtil.getColumnIndexOrThrow(_cursor, "Preparation");
      final int _cursorIndexOfWorkTime = CursorUtil.getColumnIndexOrThrow(_cursor, "WorkTime");
      final int _cursorIndexOfRestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RestTime");
      final int _cursorIndexOfCycles = CursorUtil.getColumnIndexOrThrow(_cursor, "Cycles");
      final int _cursorIndexOfSets = CursorUtil.getColumnIndexOrThrow(_cursor, "Sets");
      final int _cursorIndexOfRestSets = CursorUtil.getColumnIndexOrThrow(_cursor, "RestSets");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "Color");
      final List<TimerModel> _result = new ArrayList<TimerModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TimerModel _item;
        _item = new TimerModel();
        _item.Id = _cursor.getInt(_cursorIndexOfId);
        _item.Name = _cursor.getString(_cursorIndexOfName);
        _item.Preparation = _cursor.getInt(_cursorIndexOfPreparation);
        _item.WorkTime = _cursor.getInt(_cursorIndexOfWorkTime);
        _item.RestTime = _cursor.getInt(_cursorIndexOfRestTime);
        _item.Cycles = _cursor.getInt(_cursorIndexOfCycles);
        _item.Sets = _cursor.getInt(_cursorIndexOfSets);
        _item.RestSets = _cursor.getInt(_cursorIndexOfRestSets);
        _item.Color = _cursor.getInt(_cursorIndexOfColor);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TimerModel getById(final long id) {
    final String _sql = "SELECT * FROM timerModel WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
      final int _cursorIndexOfPreparation = CursorUtil.getColumnIndexOrThrow(_cursor, "Preparation");
      final int _cursorIndexOfWorkTime = CursorUtil.getColumnIndexOrThrow(_cursor, "WorkTime");
      final int _cursorIndexOfRestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RestTime");
      final int _cursorIndexOfCycles = CursorUtil.getColumnIndexOrThrow(_cursor, "Cycles");
      final int _cursorIndexOfSets = CursorUtil.getColumnIndexOrThrow(_cursor, "Sets");
      final int _cursorIndexOfRestSets = CursorUtil.getColumnIndexOrThrow(_cursor, "RestSets");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "Color");
      final TimerModel _result;
      if(_cursor.moveToFirst()) {
        _result = new TimerModel();
        _result.Id = _cursor.getInt(_cursorIndexOfId);
        _result.Name = _cursor.getString(_cursorIndexOfName);
        _result.Preparation = _cursor.getInt(_cursorIndexOfPreparation);
        _result.WorkTime = _cursor.getInt(_cursorIndexOfWorkTime);
        _result.RestTime = _cursor.getInt(_cursorIndexOfRestTime);
        _result.Cycles = _cursor.getInt(_cursorIndexOfCycles);
        _result.Sets = _cursor.getInt(_cursorIndexOfSets);
        _result.RestSets = _cursor.getInt(_cursorIndexOfRestSets);
        _result.Color = _cursor.getInt(_cursorIndexOfColor);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TimerModel getByName(final String name) {
    final String _sql = "SELECT * FROM timerModel WHERE name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
      final int _cursorIndexOfPreparation = CursorUtil.getColumnIndexOrThrow(_cursor, "Preparation");
      final int _cursorIndexOfWorkTime = CursorUtil.getColumnIndexOrThrow(_cursor, "WorkTime");
      final int _cursorIndexOfRestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RestTime");
      final int _cursorIndexOfCycles = CursorUtil.getColumnIndexOrThrow(_cursor, "Cycles");
      final int _cursorIndexOfSets = CursorUtil.getColumnIndexOrThrow(_cursor, "Sets");
      final int _cursorIndexOfRestSets = CursorUtil.getColumnIndexOrThrow(_cursor, "RestSets");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "Color");
      final TimerModel _result;
      if(_cursor.moveToFirst()) {
        _result = new TimerModel();
        _result.Id = _cursor.getInt(_cursorIndexOfId);
        _result.Name = _cursor.getString(_cursorIndexOfName);
        _result.Preparation = _cursor.getInt(_cursorIndexOfPreparation);
        _result.WorkTime = _cursor.getInt(_cursorIndexOfWorkTime);
        _result.RestTime = _cursor.getInt(_cursorIndexOfRestTime);
        _result.Cycles = _cursor.getInt(_cursorIndexOfCycles);
        _result.Sets = _cursor.getInt(_cursorIndexOfSets);
        _result.RestSets = _cursor.getInt(_cursorIndexOfRestSets);
        _result.Color = _cursor.getInt(_cursorIndexOfColor);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
