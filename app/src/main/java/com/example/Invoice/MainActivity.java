package com.example.Invoice;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    Button save;
    EditText cname;
    String customerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize webview
        myWebView = findViewById(R.id.myWebView);
        save=findViewById(R.id.fab);
        cname=findViewById(R.id.customer);
        //add webview client to handle event of loading
//        myWebView.setWebViewClient(new WebViewClient() {
//
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerName=cname.getText().toString();
                String htmlDocument="<html> <head> <style type=\"text/css\"> .clearfix:after {content: \"\"; display: table; clear: both; } a {color: #5D6975; text-decoration: underline; } body {position: relative; width: 21cm; height: 29.7cm; margin: 0 auto; color: #001028; background: #FFFFFF; font-family: Arial, sans-serif; font-size: 12px; font-family: Arial; } header {padding: 10px 0; margin-bottom: 30px; } #logo {text-align: center; margin-bottom: 10px; } #logo img {width: 90px; } h1 {border-top: 1px solid  #5D6975; border-bottom: 1px solid  #5D6975; color: #5D6975; font-size: 2.4em; line-height: 1.4em; font-weight: normal; text-align: center; margin: 0 0 20px 0; background: url(dimension.png); } #project {float: left; } #project span {color: #5D6975; text-align: right; width: 52px; margin-right: 10px; display: inline-block; font-size: 0.8em; } #company {float: right; text-align: right; } #project div, #company div {white-space: nowrap; } table {width: 100%; border-collapse: collapse; border-spacing: 0; margin-bottom: 20px; } table tr:nth-child(2n-1) td {background: #F5F5F5; } table th, table td {text-align: center; } table th {padding: 5px 20px; color: #5D6975; border-bottom: 1px solid #C1CED9; white-space: nowrap; font-weight: normal; } table .service, table .desc {text-align: left; } table td {padding: 20px; text-align: right; } table td.service, table td.desc {vertical-align: top; } table td.unit, table td.qty, table td.total {font-size: 1.2em; } table td.grand {border-top: 1px solid #5D6975;; } #notices .notice {color: #5D6975; font-size: 1.2em; } footer {color: #5D6975; width: 100%; height: 30px; position: absolute; bottom: 0; border-top: 1px solid #C1CED9; padding: 8px 0; text-align: center; } </style> </head> <body> <header class=\"clearfix\"> <h1>INVOICE</h1> <div id=\"company\" class=\"clearfix\"> <div>Shop Name</div> <div>455 Foggy Heights,<br /> AZ 85004, US</div> <div>(602) 519-0450</div> <div>Shop@example.com</div> </div> <div id=\"project\"> <div><span>Name</span> "+customerName+"</div> <div><span>ADDRESS</span> 796 Silver Harbour, TX 79273, US</div> <div><span>DATE</span> August 17, 2019</div> <div><span>DUE DATE</span> September 17, 2019</div> </div> </header> <main> <table> <thead> <tr> <th class=\"service\">SERVICE</th> <th class=\"desc\">DESCRIPTION</th> <th>PRICE</th> <th>QTY</th> <th>TOTAL</th> </tr> </thead> <tbody> <tr> <td class=\"service\">Training</td> <td class=\"desc\">Initial training sessions for staff responsible for uploading web content</td> <td class=\"unit\">$40.00</td> <td class=\"qty\">4</td> <td class=\"total\">$160.00</td> </tr> <tr> <td colspan=\"4\">SUBTOTAL</td> <td class=\"total\">$5,200.00</td> </tr> <tr> <td colspan=\"4\">TAX 25%</td> <td class=\"total\">$1,300.00</td> </tr> <tr> <td colspan=\"4\" class=\"grand total\">GRAND TOTAL</td> <td class=\"grand total\">$6,500.00</td> </tr> </tbody> </table> </main> </body> </html>";
                myWebView.loadData(htmlDocument, "text/HTML", "UTF-8");
                createWebPrintJob(myWebView);
            }
        });
    }
    private void createWebPrintJob(WebView webView) {

        //create object of print manager in your device
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);

        //create object of print adapter
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        //provide name to your newly generated pdf file
        String jobName = getString(R.string.app_name) + " Print Test";

        //open print dialog
        printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
    }

}
