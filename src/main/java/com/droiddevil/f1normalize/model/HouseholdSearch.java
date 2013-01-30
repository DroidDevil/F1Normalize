package com.droiddevil.f1normalize.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class HouseholdSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class Results implements Serializable {

        private static final long serialVersionUID = 1L;

        @SerializedName("@count")
        private int count;

        @SerializedName("@pageNumber")
        private int pageNumber;

        @SerializedName("@totalRecords")
        private int totalRecords;

        @SerializedName("@additionalPages")
        private int additionalPages;

        private List<Household> household;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getAdditionalPages() {
            return additionalPages;
        }

        public void setAdditionalPages(int additionalPages) {
            this.additionalPages = additionalPages;
        }

        public List<Household> getHousehold() {
            return household;
        }

        public void setHousehold(List<Household> household) {
            this.household = household;
        }

    }

    private Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
