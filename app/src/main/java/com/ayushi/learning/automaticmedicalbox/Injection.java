package com.ayushi.learning.automaticmedicalbox;

import android.content.Context;
import androidx.annotation.NonNull;

import com.ayushi.learning.automaticmedicalbox.data.source.MedicineRepository;
import com.ayushi.learning.automaticmedicalbox.data.source.local.MedicinesLocalDataSource;

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}
