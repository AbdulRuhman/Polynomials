package abdulruhman.com.polyds.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import abdulruhman.com.polyds.R;
import abdulruhman.com.polyds.calculations.Function;

/**
 * A fragment with a Google +1 button.
 */
public class PolyExec extends Fragment {

    EditText txt_f,txt_point,txt_result;

    Button button;

    public PolyExec() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poly_exec, container, false);
        txt_f=view.findViewById(R.id.txt_f);
        txt_point=view.findViewById(R.id.txt_point);
        txt_result=view.findViewById(R.id.txt_result);
        button=view.findViewById(R.id.button_calculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                execute();
            }
        });



        return view;
    }
    void execute(){
        Editable f=txt_f.getText();
        Editable point=txt_point.getText();
        float p = Float.parseFloat(point.toString().trim());
        Function y = new Function(f.toString().trim());
        float res = y.execute(p);
        txt_result.setText(res+"");


    }
    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


}
