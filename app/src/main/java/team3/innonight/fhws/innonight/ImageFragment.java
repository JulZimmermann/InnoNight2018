package team3.innonight.fhws.innonight;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import team3.innonight.fhws.innonight.model.Notification;
import team3.innonight.fhws.innonight.service.NotificationService;

public class ImageFragment extends Fragment {

    private ImageView imageHolder;
    private EditText edFeedback;
    private final int requestCode = 20;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageHolder = view.findViewById(R.id.captured_photo);

        Button btnPicture = view.findViewById(R.id.takePhoto);
        btnPicture.setOnClickListener(this::takePhoto);

        edFeedback = view.findViewById(R.id.edNachricht);

        Button btnSend = view.findViewById(R.id.sendPhoto);
        btnSend.setOnClickListener(this::sendFeedback);
    }

    private void takePhoto(View v){
        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(photoCaptureIntent, requestCode);
    }

    private void sendFeedback(View view) {
        NotificationService.getInstance().addNotification(
                new Notification(
                        String.format("Feedback %s", edFeedback.getText()),
                        Notification.Status.Pending, "Ihr Antrag wird bearbeitet", Notification.Type.Feedback
                ));

        Fragment fragment = new CategoryFragment();
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }
}
