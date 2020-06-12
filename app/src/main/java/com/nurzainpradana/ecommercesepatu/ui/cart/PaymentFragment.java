package com.nurzainpradana.ecommercesepatu.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.PaymentMethod;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
import com.nurzainpradana.ecommercesepatu.BuildConfig;
import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.CustomerModel;
import com.nurzainpradana.ecommercesepatu.model.cost.Rajaongkir;


public class PaymentFragment extends Fragment implements TransactionFinishedCallback {

    private Button btnPayment;
    private TextView tvAddress;

    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPayment = view.findViewById(R.id.btn_payment);

        View viewDetail = view.findViewById(R.id.includeDetail);
        tvAddress = viewDetail.findViewById(R.id.tv_address);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Rajaongkir rajaongkir = getArguments().getParcelable("rajaongkir");

        if (rajaongkir!=null) {
            tvAddress.setText(rajaongkir.getDestinationDetails().getCityName());
        }

        initMidTransSDK();
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action
                MidtransSDK.getInstance().setTransactionRequest(CustomerModel.transactionRequest(
                        "ZN001",
                        500000,
                        1,
                        "Adidas Falcon"));
                MidtransSDK.getInstance().startPaymentUiFlow(getActivity(), PaymentMethod.BANK_TRANSFER_MANDIRI);
            }
        });
    }

    private void initMidTransSDK() {
        //inisialisasi midtrans
        SdkUIFlowBuilder.init()
                .setClientKey(BuildConfig.CLIENT_KEY) // client_key is mandatory
                .setContext(getActivity()) // context is mandatory
                .setMerchantBaseUrl(BuildConfig.BASE_URL) //set merchant url (required)
                .enableLog(true) // enable sdk log (optional)
                .setTransactionFinishedCallback(this)
                .setColorTheme(new CustomColorTheme("#FFE51255", "#B61548", "#FFE51255")) // set theme. it will replace theme on snap theme on MAP ( optional)
                .buildSDK();


    }

    @Override
    public void onTransactionFinished(TransactionResult transactionResult) {
        //untuk result
        if (transactionResult.getResponse() != null) {
            switch (transactionResult.getStatus()) {
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(getActivity(), "Transaksi Sukses dengan ID " + transactionResult.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;

                    case TransactionResult.STATUS_PENDING:
                    Toast.makeText(getActivity(), "Transaksi Tertunda dengan ID " + transactionResult.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;

                    case TransactionResult.STATUS_FAILED:
                    Toast.makeText(getActivity(), "Transaksi Gagal dengan ID " + transactionResult.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
            }

            transactionResult.getResponse().getValidationMessages();

        } else if (transactionResult.isTransactionCanceled()) {
            Toast.makeText(getActivity(), "Transaksi Dibatalkan", Toast.LENGTH_SHORT).show();
        } else {
            if (transactionResult.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)) {
                Toast.makeText(getActivity(), "Transaksi Invalid", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Transaksi Finish with Fail", Toast.LENGTH_SHORT).show();
            }
        }
    }
}