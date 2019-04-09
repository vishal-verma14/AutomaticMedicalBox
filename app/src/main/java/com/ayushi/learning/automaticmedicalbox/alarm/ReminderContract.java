package com.ayushi.learning.automaticmedicalbox.alarm;

import com.ayushi.learning.automaticmedicalbox.BasePresenter;
import com.ayushi.learning.automaticmedicalbox.BaseView;
import com.ayushi.learning.automaticmedicalbox.data.source.History;
import com.ayushi.learning.automaticmedicalbox.data.source.MedicineAlarm;


public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
