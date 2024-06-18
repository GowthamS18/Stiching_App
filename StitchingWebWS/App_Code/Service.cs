using System;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Linq;
using System.Data.SqlClient;
using System.Data;
using System.Net.Mail;
using System.Net;
//using Microsoft.Phone.Maps.Services;
using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Data.SqlClient;
using System.IO;
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]

public class Service : System.Web.Services.WebService
{
    SqlConnection con = new SqlConnection("server=.\\sqlexpress;database=StitchingAndroDB;integrated security=true;");
    SqlCommand cmd;
    public Service()
    {

    }

    [WebMethod]
    public string getuser(String username)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from register where username='" + username + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            if (dt.Rows.Count > 0)
            {
                s = dt.Rows[i]["username"].ToString() + ",";
                s = s + dt.Rows[i]["password"].ToString() + ",";
                s = s + dt.Rows[i]["phone"].ToString() + ",";
                s = s + dt.Rows[i]["email"].ToString() + ",";
                s = s + dt.Rows[i]["htown"].ToString() + ",";
            }
        }
        return s;
    }
    [WebMethod]
    public string updateuser(String username, String password, String phone, String email, String hometown, String sex)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        if (username == "" || password == "" || phone == "" || email == "" || hometown == "" || sex == "")
        {
            s = "Pleasse fill the details";
        }
        else
        {
            cmd = new SqlCommand("update into register values('" + username + "','" + password + "','" + phone + "','" + email + "','" + hometown + "','" + sex + "')", con);
            cmd.ExecuteNonQuery();
            s = "Register Successfully";
        }
        return s;
    }
    [WebMethod]
    public String userlogin(String username, String password)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        cmd = new SqlCommand("select * from registration where userid='" + username + "' and password='" + password + "'", con);
        SqlDataReader dr = cmd.ExecuteReader();
        if (dr.Read())
        {
            s = "ok";
        }
        else
        {
            s = "not OK";
        }
        dr.Close();
        return s;
    }
    [WebMethod]
    public String vendorlogin(String username, String password)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("select * from vendor where vendorid='" + username + "' and vendorpwd='" + password + "'", con);
        SqlDataReader dr = cmd.ExecuteReader();
        if (dr.Read())
        {
            s = "ok";
        }
        else
        {
            s = "not OK";
        }
        dr.Close();
        return s;
    }

    [WebMethod]
    public String getVendors(String p1, String p2)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from vendor where district='" + p1 + "' and location='" + p2 + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }


    [WebMethod]
    public String getoneOrderDetails(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from tbl_order where order_id='" + p1 + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }


    [WebMethod]
    public String getCustomerOrders(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from tbl_order where user_name='" + p1 + "' order by order_id desc", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }


    [WebMethod]
    public String getVendorOrders(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from tbl_order where vendorid='" + p1 + "' order by order_id desc", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }

    public string apicall(string url)
    {
        HttpWebRequest httpreq = (HttpWebRequest)WebRequest.Create(url);
        try
        {
            HttpWebResponse httpres = (HttpWebResponse)httpreq.GetResponse();
            StreamReader sr = new StreamReader(httpres.GetResponseStream());
            string results = sr.ReadToEnd();
            sr.Close();
            return results;
        }
        catch
        {
            return "0";
        }
    }
    [WebMethod]
    public String register(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9)
    {
        string s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();

        SqlDataAdapter da1 = new SqlDataAdapter("select * from registration where userid='" + p4 + "'", con);
        DataTable dt1 = new DataTable();
        
        da1.Fill(dt1);
        if (dt1.Rows.Count > 0)
        {
            s = "Already Register";
        }
        else
        {
            cmd = new SqlCommand("insert into registration values('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + p7 + "','" + p8 + "','" + p9 + "')", con);
            cmd.ExecuteNonQuery();
            s = "Register Successfully....";
        }
        return s;
    }

    [WebMethod]
    public String vendorregister(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10, String p11, String p12)
    {
        string s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();

        SqlDataAdapter da1 = new SqlDataAdapter("select * from vendor where vendorid='" + p1 + "'", con);
        DataTable dt1 = new DataTable();
        da1.Fill(dt1);
        if (dt1.Rows.Count > 0)
        {
            s = "Already Register";
        }
        else
        {
            SqlCommand cmd = new SqlCommand("select max(id)+1 from vendor", con);
            int iID = (int)cmd.ExecuteScalar();

            String imageFileExtension = p11.Substring(p11.LastIndexOf("."), p11.Length - p11.LastIndexOf("."));
            var bytes = Convert.FromBase64String(p12);
            using (var imageFile = new FileStream(Server.MapPath("logo/" + iID + imageFileExtension), FileMode.Create))
            {
                imageFile.Write(bytes, 0, bytes.Length);
                imageFile.Flush();
            }
            cmd = new SqlCommand("insert into vendor values('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + p7 + "','" + p8 + "','" + p9 + "','" + p10 + "','" + iID + imageFileExtension + "')", con);
            cmd.ExecuteNonQuery();
            s = "Register Successfully....";
        }
        return s;
    }

    [WebMethod]
    public String AddOrder(String p1, String p2, String p3, String p4, String p5, String p6)
    {
        string s = "Error";
        if (con.State == ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into tbl_order values('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + System.DateTime.Now.ToString() + "','Pending','Pending','0','Measurement Not Taken')", con);
        cmd.ExecuteNonQuery();
        s = "Ordered Successfully Placed....";
        return s;
    }
    
    [WebMethod]
    public String AddMeasurements(String p1, String p2, String p3, String p4, String p5, String p6)
    {
        string s = "Error";
        if (con.State == ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into measurements values('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + System.DateTime.Now.ToString() + "')", con);
        cmd.ExecuteNonQuery();

        cmd = new SqlCommand("update tbl_order set measurementStatus = '" + p6 + "' where order_id= '" + p1 + "'", con);
        cmd.ExecuteNonQuery();

        s = "Successfully Saved....";
        return s;
    }


    [WebMethod]
    public String AddPayments(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8)
    {
        string s = "Error";
        if (con.State == ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into tbl_pay values('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + p7 + "','" + p8 + "','" + System.DateTime.Now.ToString() + "')", con);
        cmd.ExecuteNonQuery();

        cmd = new SqlCommand("update tbl_order set payment_status = 'PAID' where order_id= '" + p1 + "'", con);
        cmd.ExecuteNonQuery();

        s = "Successfully Saved....";
        return s;
    }


    [WebMethod]
    public String UpdateStatus(String p1, String p2, String p3)
    {
        string s = "Error";
        if (con.State == ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("update tbl_order set charge='" + p2 + "',Status = '" + p3 + "' where order_id= '" + p1 + "'", con);
        cmd.ExecuteNonQuery();
        s = "Successfully Updated....";
        return s;
    }



    [WebMethod]
    public String getPayments(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from tbl_pay where order_id='" + p1 + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }


    [WebMethod]
    public String getMeasurements(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select * from measurements where order_id='" + p1 + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }

    [WebMethod]
    public String getOrderID(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select order_id from tbl_order where vendorid='" + p1 + "' order by order_id desc", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }


    [WebMethod]
    public String getCustOrderID(String p1)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da = new SqlDataAdapter("select order_id from tbl_order where user_name='" + p1 + "' order by order_id desc", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            for (int j = 0; j < dt.Columns.Count; j++)
            {
                if (j == dt.Columns.Count - 1)
                {
                    s += dt.Rows[i][j].ToString();
                }
                else
                {
                    s += dt.Rows[i][j].ToString() + ",";
                }
            }
            if (i < dt.Rows.Count - 1) s += "#";
        }
        Char delimiter = '#';
        String[] substrings = s.Split(delimiter);
        int ij = substrings.Length;
        return s;
    }

    //IGeocoder geocoder = new GoogleGeocoder() {  };
    //Address[] addresses = geocoder.Geocode("#65/1 bangalore").ToArray();
    //foreach (Address adrs in addresses)
    //{
    //    Response.Write("address:"+adrs.Coordinates);
    //}


    [WebMethod]
    public String slist(String name)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        SqlDataAdapter da1 = new SqlDataAdapter("select * from selection where suser='" + name + "'", con);
        DataTable dt1 = new DataTable();
        da1.Fill(dt1);
        if (dt1.Rows.Count > 0)
        {
            SqlDataAdapter da = new SqlDataAdapter("select * from selection where dates='" + System.DateTime.Now.ToShortDateString() + "'", con);
            DataTable dt = new DataTable();
            da.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                s = "ID,ArrangeUser,Selected Name,Stopping,Amount,date,Hometown,";
                for (int i = 0; i < dt.Rows.Count; i++)
                {
                    for (int j = 0; j < dt.Columns.Count; j++)
                    {
                        s += dt.Rows[i][j].ToString();
                        s = s + ",";
                    }
                }
            }
        }
        else
        {
            s = "NO Values";
        }
        return s;
    }


    [WebMethod]
    public String updatelocation(String p1, String p2, String p3, String p4, String p5, String p6)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();
        cmd = new SqlCommand("delete from curlocation where vehicleno='" + p1 + "'", con);
        cmd.ExecuteNonQuery();
        cmd = new SqlCommand("insert into curlocation values ('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + System.DateTime.Now.ToString() + "')", con);
        cmd.ExecuteNonQuery();
        s = "ok";
        return s;
    }

}
