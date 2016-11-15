package com.sample.db.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TrackExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public TrackExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTrackidIsNull() {
            addCriterion("TrackId is null");
            return (Criteria) this;
        }

        public Criteria andTrackidIsNotNull() {
            addCriterion("TrackId is not null");
            return (Criteria) this;
        }

        public Criteria andTrackidEqualTo(Integer value) {
            addCriterion("TrackId =", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidNotEqualTo(Integer value) {
            addCriterion("TrackId <>", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidGreaterThan(Integer value) {
            addCriterion("TrackId >", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TrackId >=", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidLessThan(Integer value) {
            addCriterion("TrackId <", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidLessThanOrEqualTo(Integer value) {
            addCriterion("TrackId <=", value, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidIn(List<Integer> values) {
            addCriterion("TrackId in", values, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidNotIn(List<Integer> values) {
            addCriterion("TrackId not in", values, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidBetween(Integer value1, Integer value2) {
            addCriterion("TrackId between", value1, value2, "trackid");
            return (Criteria) this;
        }

        public Criteria andTrackidNotBetween(Integer value1, Integer value2) {
            addCriterion("TrackId not between", value1, value2, "trackid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAlbumidIsNull() {
            addCriterion("AlbumId is null");
            return (Criteria) this;
        }

        public Criteria andAlbumidIsNotNull() {
            addCriterion("AlbumId is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumidEqualTo(Integer value) {
            addCriterion("AlbumId =", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotEqualTo(Integer value) {
            addCriterion("AlbumId <>", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThan(Integer value) {
            addCriterion("AlbumId >", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AlbumId >=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThan(Integer value) {
            addCriterion("AlbumId <", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThanOrEqualTo(Integer value) {
            addCriterion("AlbumId <=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidIn(List<Integer> values) {
            addCriterion("AlbumId in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotIn(List<Integer> values) {
            addCriterion("AlbumId not in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidBetween(Integer value1, Integer value2) {
            addCriterion("AlbumId between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotBetween(Integer value1, Integer value2) {
            addCriterion("AlbumId not between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIsNull() {
            addCriterion("MediaTypeId is null");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIsNotNull() {
            addCriterion("MediaTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andMediatypeidEqualTo(Integer value) {
            addCriterion("MediaTypeId =", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotEqualTo(Integer value) {
            addCriterion("MediaTypeId <>", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidGreaterThan(Integer value) {
            addCriterion("MediaTypeId >", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MediaTypeId >=", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidLessThan(Integer value) {
            addCriterion("MediaTypeId <", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidLessThanOrEqualTo(Integer value) {
            addCriterion("MediaTypeId <=", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIn(List<Integer> values) {
            addCriterion("MediaTypeId in", values, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotIn(List<Integer> values) {
            addCriterion("MediaTypeId not in", values, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidBetween(Integer value1, Integer value2) {
            addCriterion("MediaTypeId between", value1, value2, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("MediaTypeId not between", value1, value2, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andGenreidIsNull() {
            addCriterion("GenreId is null");
            return (Criteria) this;
        }

        public Criteria andGenreidIsNotNull() {
            addCriterion("GenreId is not null");
            return (Criteria) this;
        }

        public Criteria andGenreidEqualTo(Integer value) {
            addCriterion("GenreId =", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidNotEqualTo(Integer value) {
            addCriterion("GenreId <>", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidGreaterThan(Integer value) {
            addCriterion("GenreId >", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GenreId >=", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidLessThan(Integer value) {
            addCriterion("GenreId <", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidLessThanOrEqualTo(Integer value) {
            addCriterion("GenreId <=", value, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidIn(List<Integer> values) {
            addCriterion("GenreId in", values, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidNotIn(List<Integer> values) {
            addCriterion("GenreId not in", values, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidBetween(Integer value1, Integer value2) {
            addCriterion("GenreId between", value1, value2, "genreid");
            return (Criteria) this;
        }

        public Criteria andGenreidNotBetween(Integer value1, Integer value2) {
            addCriterion("GenreId not between", value1, value2, "genreid");
            return (Criteria) this;
        }

        public Criteria andComposerIsNull() {
            addCriterion("Composer is null");
            return (Criteria) this;
        }

        public Criteria andComposerIsNotNull() {
            addCriterion("Composer is not null");
            return (Criteria) this;
        }

        public Criteria andComposerEqualTo(String value) {
            addCriterion("Composer =", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerNotEqualTo(String value) {
            addCriterion("Composer <>", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerGreaterThan(String value) {
            addCriterion("Composer >", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerGreaterThanOrEqualTo(String value) {
            addCriterion("Composer >=", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerLessThan(String value) {
            addCriterion("Composer <", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerLessThanOrEqualTo(String value) {
            addCriterion("Composer <=", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerLike(String value) {
            addCriterion("Composer like", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerNotLike(String value) {
            addCriterion("Composer not like", value, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerIn(List<String> values) {
            addCriterion("Composer in", values, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerNotIn(List<String> values) {
            addCriterion("Composer not in", values, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerBetween(String value1, String value2) {
            addCriterion("Composer between", value1, value2, "composer");
            return (Criteria) this;
        }

        public Criteria andComposerNotBetween(String value1, String value2) {
            addCriterion("Composer not between", value1, value2, "composer");
            return (Criteria) this;
        }

        public Criteria andMillisecondsIsNull() {
            addCriterion("Milliseconds is null");
            return (Criteria) this;
        }

        public Criteria andMillisecondsIsNotNull() {
            addCriterion("Milliseconds is not null");
            return (Criteria) this;
        }

        public Criteria andMillisecondsEqualTo(Integer value) {
            addCriterion("Milliseconds =", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsNotEqualTo(Integer value) {
            addCriterion("Milliseconds <>", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsGreaterThan(Integer value) {
            addCriterion("Milliseconds >", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Milliseconds >=", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsLessThan(Integer value) {
            addCriterion("Milliseconds <", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsLessThanOrEqualTo(Integer value) {
            addCriterion("Milliseconds <=", value, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsIn(List<Integer> values) {
            addCriterion("Milliseconds in", values, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsNotIn(List<Integer> values) {
            addCriterion("Milliseconds not in", values, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsBetween(Integer value1, Integer value2) {
            addCriterion("Milliseconds between", value1, value2, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andMillisecondsNotBetween(Integer value1, Integer value2) {
            addCriterion("Milliseconds not between", value1, value2, "milliseconds");
            return (Criteria) this;
        }

        public Criteria andBytesIsNull() {
            addCriterion("Bytes is null");
            return (Criteria) this;
        }

        public Criteria andBytesIsNotNull() {
            addCriterion("Bytes is not null");
            return (Criteria) this;
        }

        public Criteria andBytesEqualTo(Integer value) {
            addCriterion("Bytes =", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesNotEqualTo(Integer value) {
            addCriterion("Bytes <>", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesGreaterThan(Integer value) {
            addCriterion("Bytes >", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bytes >=", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesLessThan(Integer value) {
            addCriterion("Bytes <", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesLessThanOrEqualTo(Integer value) {
            addCriterion("Bytes <=", value, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesIn(List<Integer> values) {
            addCriterion("Bytes in", values, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesNotIn(List<Integer> values) {
            addCriterion("Bytes not in", values, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesBetween(Integer value1, Integer value2) {
            addCriterion("Bytes between", value1, value2, "bytes");
            return (Criteria) this;
        }

        public Criteria andBytesNotBetween(Integer value1, Integer value2) {
            addCriterion("Bytes not between", value1, value2, "bytes");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNull() {
            addCriterion("UnitPrice is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNotNull() {
            addCriterion("UnitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceEqualTo(BigDecimal value) {
            addCriterion("UnitPrice =", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <>", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThan(BigDecimal value) {
            addCriterion("UnitPrice >", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice >=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThan(BigDecimal value) {
            addCriterion("UnitPrice <", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIn(List<BigDecimal> values) {
            addCriterion("UnitPrice in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotIn(List<BigDecimal> values) {
            addCriterion("UnitPrice not in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice not between", value1, value2, "unitprice");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Track
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 05 12:50:06 CEST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Track
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
