package com.student.course.errorresponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * More specific information about an encountered error.
 *
 * @author Johnny Hernandez
 */
@ApiModel(description = "More specific information about an encountered error")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-14T11:09:36.967-05:00")

public class APIError implements Serializable {
	private String code;

	private String message;

	private String target;

	private List<APIError> details = new ArrayList<APIError>();

	private InnerError innererror;

	private String link;

	/**
	 * A server defined error code that uniquely identifies error.
	 * @return code
	 **/
	@ApiModelProperty(required = true, value = "A server defined error code that uniquely identifies error")
	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * A human-readable description of the error encountered while processing the request.
	 * @return message
	 **/
	@ApiModelProperty(required = true, value = "A human-readable description of the error encountered while processing the request")
	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * The property in question that triggered the error.
	 * @return target
	 **/
	@ApiModelProperty("The property in question that triggered the error")
	public String getTarget() {
		return this.target;
	}

	public void setTarget(final String target) {
		this.target = target;
	}

	public APIError addDetailsItem(final APIError detailsItem) {
		this.details.add(detailsItem);
		return this;
	}

	/**
	 * An array of more specific errors that led to the currently reported error.
	 * @return details
	 **/
	@ApiModelProperty("An array of more specific errors that led to the currently reported error")
	public List<APIError> getDetails() {
		return this.details;
	}

	public void setDetails(final List<APIError> details) {
		this.details = details;
	}

	/**
	 * Get innererror.
	 * @return innererror
	 **/
	@ApiModelProperty
	public InnerError getInnererror() {
		return this.innererror;
	}

	public void setInnererror(final InnerError innererror) {
		this.innererror = innererror;
	}

	/**
	 * A link to relevant documentation for this error.
	 * @return link
	 **/
	@ApiModelProperty("A link to relevant documentation for this error")
	public String getLink() {
		return this.link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		APIError aPIError = (APIError) o;
		return Objects.equals(this.code, aPIError.code)
				&& Objects.equals(this.message, aPIError.message)
				&& Objects.equals(this.target, aPIError.target)
				&& Objects.equals(this.details, aPIError.details)
				&& Objects.equals(this.innererror, aPIError.innererror)
				&& Objects.equals(this.link, aPIError.link);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.code, this.message, this.target, this.details,
				this.innererror, this.link);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(200);

		sb.append("class APIError {\n    code: ").append(toIndentedString(this.code))
				.append("\n    message: ")
				.append(toIndentedString(this.message))
				.append("\n    target: ").append(toIndentedString(this.target))
				.append("\n    details: ").append(toIndentedString(this.details))
				.append("\n    innererror: ")
				.append(toIndentedString(this.innererror))
				.append("\n    link: ").append(toIndentedString(this.link)).append("\n}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the
	 * first line).
	 * @param o The unindented object
	 * @return indented string
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
