package com.ayushi.learning.automaticmedicalbox.medicine;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

import com.ayushi.learning.automaticmedicalbox.MedicineApp;
import com.ayushi.learning.automaticmedicalbox.R;
import com.ayushi.learning.automaticmedicalbox.data.source.MedicineAlarm;
import com.ayushi.learning.automaticmedicalbox.views.RobotoBoldTextView;
import com.ayushi.learning.automaticmedicalbox.views.RobotoRegularTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    RecyclerView listView;

    private List<MedicineAlarm> medicineAlarmList;

    public MedicineAdapter(List<MedicineAlarm> medicineAlarmList) {
        this.medicineAlarmList = medicineAlarmList;
    }

    public void replaceData(List<MedicineAlarm> medicineAlarmList) {
        this.medicineAlarmList = medicineAlarmList;
        notifyDataSetChanged();
    }

    @Override
    public MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_medicine, parent, false);
        return new MedicineViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MedicineViewHolder holder, int position) {
        final MedicineAlarm medicineAlarm = medicineAlarmList.get(position);
        if (medicineAlarm == null) {
            return;
        }
        holder.tvMedTime.setText(medicineAlarm.getStringTime());
        holder.tvMedicineName.setText(medicineAlarm.getPillName());
        holder.tvDoseDetails.setText(medicineAlarm.getFormattedDose());
        holder.medicineDetails.setOnLongClickListener(v -> {
            PopupMenu popup = new PopupMenu(holder.medicineDetails.getContext(),holder.medicineDetails);
            popup.inflate(R.menu.medicine_pop_menu);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.action_edit:
                        break;
                    case R.id.action_delete:
                        break;
                }
                return false;
            });
            popup.show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return (medicineAlarmList != null && !medicineAlarmList.isEmpty()) ? medicineAlarmList.size() : 0;
    }

    static class MedicineViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_med_time)
        RobotoBoldTextView tvMedTime;

        @BindView(R.id.tv_medicine_name)
        RobotoBoldTextView tvMedicineName;

        @BindView(R.id.tv_dose_details)
        RobotoRegularTextView tvDoseDetails;

        @BindView(R.id.iv_medicine_action)
        ImageView ivMedicineAction;

        @BindView(R.id.med_details)
        RelativeLayout medicineDetails;

        MedicineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
