package abdulruhman.com.polyds.fragments;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import abdulruhman.com.polyds.R;
import abdulruhman.com.polyds.calculations.Function;


/**
 * A fragment with a Google +1 button.
 */
public class PolyOps extends Fragment {

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    String result="";

    EditText txt_func1,txt_func2,txt_result;
    RadioGroup opsGroup;
    Button button ;
    public PolyOps() {
        // Required empty public constructor
    }

    int idone=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_poly_ops, container, false);
        txt_func1=view.findViewById(R.id.txt_f1);
        txt_func2=view.findViewById(R.id.txt_f2);
        txt_result=view.findViewById(R.id.txt_res);
        opsGroup=view.findViewById(R.id.opsgroup);
    button=view.findViewById(R.id.button_calc);

        opsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radioplus:
                        idone=1;
                        break;
                    case R.id.radiominus:
                        idone=2;

                        break;
                    case R.id.radiomul:
                        idone=3;

                        break;
                    case R.id.radiodiv:
                        idone=4;

                        break;
                }
            }
        });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (idone){
                        case 1:
                            plus();
                            break;
                        case 2:
                            minus();
                            break;
                        case 3:
                            mul();
                            break;
                        case 4:
                            div();
                            break;


                    }
                }
            });





        return view;
    }
    public void plus (){

        Editable f1=txt_func1.getText();
        Editable f2=txt_func2.getText();
        Function y = new Function(f1.toString().trim());
        Function z = new Function(f2.toString().trim());
        Function res = y.addFunc(z);
        txt_result.setText(res.toString());

    }
    public void minus(){
        Editable f1=txt_func1.getText();
        Editable f2=txt_func2.getText();
        Function y = new Function(f1.toString().trim());
        Function z = new Function(f2.toString().trim());
        Function res = y.subFunc(z);
        txt_result.setText(res.toString());

    }
    public void mul(){

        Editable f1=txt_func1.getText();
        Editable f2=txt_func2.getText();
        Function y = new Function(f1.toString().trim());
        Function z = new Function(f2.toString().trim());
        Function res = y.mulFunc(z);
        txt_result.setText(res.toString());

    }
    public void div(){
        Editable f1=txt_func1.getText();
        Editable f2=txt_func2.getText();
        Function y = new Function(f1.toString().trim());
        Function z = new Function(f2.toString().trim());
        if(z.getSize()>1){
            txt_result.setText("Enter a single term function");

        }else{
        Function res = y.divFunc(z);
        txt_result.setText(res.toString());
        }
    }
    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


}
