package minister.portal.com.voiceofheart;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.attr.data;


public class SocialFragment extends Fragment {
    List<NewsBeans> data = new ArrayList<>();
    private SwipeRefreshLayout swipeContainer;


    JSONParser jsonParser = new JSONParser();
    SwipeRefreshLayout mSwipeRefreshLayout;
    ProgressDialog pDialog;
    Button button;
    private static final String SUBMIT_QUERY = "http://selfenabler.com/VoiceOfHeart/getMediaPhotoAllGSON";

    public RecyclerView mRVFishPrice;
    View view;

    public AdapterNews mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.social_layout, null);






        new AttemptRegister().execute();



        return view;
    }


    public class AttemptRegister extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("getting data...please wait!!!!");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

        }
        @Override
        protected void onCancelled() {
            pDialog.dismiss();
            super.onCancelled();
        }

        @Override
        protected String doInBackground(String... args) {

            int success;

            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("regireralldata", "pawan"));
                Log.d("request!", "starting");
                //Log.e("objectofjson", jsonObjectuser);
                JSONArray json = jsonParser.makeHttpRequest(SUBMIT_QUERY, "POST", params);
                Log.e("JSONStatus", json.toString());
                for (int i = 0; i < json.length(); i++) {
                    JSONObject json_data = json.getJSONObject(i);
                    //state calling
                    JSONObject stateobj = json_data.getJSONObject("State");

                    String stateid = stateobj.getString("id");
                    Log.e("nnewsid", stateid);
                    String statename = stateobj.getString("stateName");
                    Log.e("nnewsname", statename);
                    String countrid = stateobj.getString("countryId");
                    Log.e("nnewscountryid", countrid);


                    JSONObject disstobj = json_data.getJSONObject("MediaPhoto");

                    String newsimage = disstobj.getString("media_photo_url");
                    Log.e("nnewsid1", newsimage);
                    String newstitle = disstobj.getString("media_photo_title");
                    String newsdesc = disstobj.getString("media_photo_made_on");


                    NewsBeans newsbeans = new NewsBeans();

                    newsbeans.setNewsid(stateid);
                    newsbeans.setNewstitle(newstitle);
                    newsbeans.setStatename(newsdesc);
                    newsbeans.setCountryname(newsimage);
                    data.add(newsbeans);







                    /*String news= json_data.getString("MediaNews");
                    Log.e("nnews",news);
                    String state= json_data.getString("State");
                    Log.e("staj",state);
                    JSONObject jb = json_data.getJSONObject("Country");
                    Log.e("ppphone",jb.toString());
                    String id=jb.getString("id");
                    Log.e("iid",id);
                    String Countryname=jb.getString("countryName");
                    Log.e("cc",Countryname);
                    String disst = json_data.getString("District");
                    Log.e("disst",disst);
*/
                }

                // success = json.getInt(TAG_SUCCESS);
                // Log.e("logg", success + "");
               /* if (success == 1) {
                    Log.d("Registered successfully", json.toString());

                    return json.getString(TAG_MESSAGE);

                } else {
                    return json.getString(TAG_MESSAGE);
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String messagfinde) {

            mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeContainer);
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mRVFishPrice.setAdapter(mAdapter);

                }
            });


            mRVFishPrice = (RecyclerView) view.findViewById(R.id.fishPriceList);
            mAdapter = new AdapterNews(getActivity(), data);
            mRVFishPrice.setAdapter(mAdapter);
            mRVFishPrice.setLayoutManager(new LinearLayoutManager(getActivity()));
            dismissProgressDialog();
            mSwipeRefreshLayout.setRefreshing(false);


        }

        private void dismissProgressDialog() {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();

            }
        }

    }
   /* public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    *//**
     * Converting dp to pixel
     *//*
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }*/
}
